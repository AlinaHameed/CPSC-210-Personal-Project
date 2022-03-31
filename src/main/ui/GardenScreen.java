package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Garden;

//represents the window within the garden element of application
public class GardenScreen implements ActionListener {

    private JFrame gardenWindow;
    private JLabel textLabel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton genusButton;
    private JButton numberButton;
    private JButton returnButton;
    private Font regFont = new Font("Times New Roman", Font.PLAIN, 20);
    private Garden currentGarden;
    private boolean hasLily;
    private boolean hasAnthurium;
    private boolean hasFicus;

    //MODIFIES: this
    //EFFECTS: runs the garden
    public void garden(Garden userGarden) {
        hasAnthurium = false;
        hasLily = false;
        hasFicus = false;
        currentGarden = userGarden;
        setUpGardenWindow();
        setUpMainButtons();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - gardenWindow.getWidth()) / 2;
        int y = (screenSize.height - gardenWindow.getHeight()) / 2;
        gardenWindow.setLocation(x, y);
        gardenWindow.setVisible(true);

        this.gardenWindow.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: creates the garden's main window
    public void setUpGardenWindow() {
        this.gardenWindow = new JFrame("Garden");
        gardenWindow.setSize(725, 625);
        gardenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gardenWindow.setLayout(null);

        textLabel = new JLabel("Welcome to the garden! Select one of the actions");
        textLabel.setFont(regFont);
        textLabel.setForeground(Color.black);

        mainPanel = new JPanel();
        mainPanel.setBounds((gardenWindow.getWidth() / 2) - 300, 100, 600, 500);
        mainPanel.add(textLabel);

        this.gardenWindow.setResizable(false);
        this.gardenWindow.add(mainPanel);
    }

    //EFFECTS: creates the buttons and button panel that is added to main window
    public void setUpMainButtons() {

        buttonPanel = new JPanel();
        buttonPanel.setBounds((gardenWindow.getWidth() / 2) - 150, 400, 300, 100);

        genusButton = new JButton("plants sent to the garden this game?");
        genusButton.addActionListener(this);
        numberButton = new JButton("how many plants are in your garden?");
        numberButton.addActionListener(this);
        returnButton = new JButton("return the main menu");
        returnButton.addActionListener(this);

        buttonPanel.add(genusButton);
        buttonPanel.add(numberButton);
        buttonPanel.add(returnButton);

        this.gardenWindow.add(buttonPanel);

    }

    //MODIFIES: this
    //EFFECTS: sets the boolean values to reflect which genus are in the garden
    private void genusInGarden() {
        for (int i = 0; i < currentGarden.getNumPlants(); i++) {
            if (currentGarden.getIndexPlant(i).getGenus().equals("lily")) {
                hasLily = true;
            }
            if (currentGarden.getIndexPlant(i).getGenus().equals("anthurium")) {
                hasAnthurium = true;
            }
            if (currentGarden.getIndexPlant(i).getGenus().equals("ficus")) {
                hasFicus = true;
            }
        }
        setGardenTextToGenus();
    }


    //MODIFIES: this
    //EFFECTS: sets the text to display which genus in the current garden
    private void setGardenTextToGenus() {
        currentGarden.logGenus(hasFicus,hasLily,hasAnthurium);
        if (hasFicus && hasLily && hasAnthurium) {
            textLabel.setText("You've sent plants with the genus type: lily, ficus and anthurium");
        } else if (hasFicus && hasLily) {
            textLabel.setText("You've sent plants with the genus type: lily and ficus");
        } else if (hasLily && hasAnthurium) {
            textLabel.setText("You've plants with the genus type: lily and anthurium");
        } else if (hasAnthurium && hasFicus) {
            textLabel.setText("You've sent plants with the genus type: ficus and anthurium");
        } else if (hasFicus) {
            textLabel.setText("You've sent plants with the genus type: ficus");
        } else if (hasLily) {
            textLabel.setText("You've sent plants with the genus type: lily");
        } else if (hasAnthurium) {
            textLabel.setText("You've sent plants with the genus type: anthurium");
        } else {
            textLabel.setText("none!");
        }
    }

    //MODIFIES: this
    //EFFECTS: handles the actions of the buttons and changes the text accordingly
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == genusButton) {
            genusInGarden();
        } else if (e.getSource() == numberButton) {
            textLabel.setText("You currently have a total of " + currentGarden.getNumPlants() + " in your garden!");
        } else if (e.getSource() == returnButton) {
            this.gardenWindow.setVisible(false);
            new MainMenuGUI().createGUI(this.currentGarden);
        }
    }
}
