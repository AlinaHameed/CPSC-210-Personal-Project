package ui;

import model.Garden;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenuGUI implements ActionListener {

    private JFrame window;
    private Font regFont = new Font("Times New Roman", Font.PLAIN, 20);

    private JPanel mainMenuPanel;
    private JPanel mainMenuButtons;
    private JLabel mainMenuText;
    private JButton seedlingButton;
    private JButton gardenButton;
    private JButton saveButton;
    private JButton loadButton;

    private static final String JSON_STORE = "./data/garden.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Garden myGarden;

    //EFFECTS: Constructs the greenhouse game GUI
    public void createGUI(Garden myGarden) {
        setUpMenuWindow();
        setUpMainButtons();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - window.getWidth()) / 2;
        int y = (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y);
        window.setVisible(true);

        this.myGarden = myGarden;
        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);
        window.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: creates the main window for this section of selctions
    public void setUpMenuWindow() {

        this.window = new JFrame("Floral Tamagotchi");
        window.setSize(725, 625);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        mainMenuText = new JLabel("Select one of the following actions!");
        mainMenuText.setFont(regFont);
        mainMenuText.setForeground(Color.black);

        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds((window.getWidth() / 2) - 300, 100, 600, 500);
        mainMenuPanel.add(mainMenuText);

        this.window.add(mainMenuPanel);
    }

    //EFFECTS: sets up the main menu buttons with action listeners onto a panel which is added to the
    // window
    public void setUpMainButtons() {

        mainMenuButtons = new JPanel();
        mainMenuButtons.setBounds((window.getWidth() / 3), 400, (window.getWidth() / 3), 100);

        seedlingButton = new JButton("seedling");
        seedlingButton.addActionListener(this);
        gardenButton = new JButton("garden");
        gardenButton.addActionListener(this);
        saveButton = new JButton("save");
        saveButton.addActionListener(this);
        loadButton = new JButton("load");
        loadButton.addActionListener(this);

        mainMenuButtons.add(seedlingButton);
        mainMenuButtons.add(gardenButton);
        mainMenuButtons.add(saveButton);
        mainMenuButtons.add(loadButton);

        window.add(mainMenuButtons);
    }

    //EFFECTS: saves the current garden to file
    private void saveGarden() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.myGarden);
            this.jsonWriter.close();
            mainMenuText.setText("Your current garden has been saved to file!");
        } catch (IOException ex) {
            mainMenuText.setText("No garden available to save");
        }
    }

    //MODIFIES: this
    //EFFECTS: loads a garden that is on file
    private void loadGarden() {
        try {
            myGarden = jsonReader.read();
            mainMenuText.setText("Your current garden has been loaded to file!");
        } catch (IOException ex) {
            mainMenuText.setText("Unable to write garden to file");
        }
    }

    //EFFECTS: handles actions and send to according screen
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seedlingButton) {
            new SeedlingScreen().seedling(myGarden);
            window.setVisible(false);
        } else if (e.getSource() == gardenButton) {
            new GardenScreen().garden(myGarden);
            window.setVisible(false);
        } else if (e.getSource() == loadButton) {
            mainMenuText.setText("Your garden has been loaded to file!");
            loadGarden();
        } else if (e.getSource() == saveButton) {
            mainMenuText.setText("Your garden has been saved to file!");
            saveGarden();
        }
    }
}
