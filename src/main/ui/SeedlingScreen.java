package ui;

import model.Garden;
import model.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeedlingScreen implements ActionListener {

    private JFrame seedlingWindow;
    private JLabel textLabel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton lilyButton;
    private JButton ficusButton;
    private JButton anthuriumButton;
    private Font titleFont = new Font("Monospaced", Font.BOLD, 40);
    private Font regFont = new Font("Times New Roman", Font.PLAIN, 20);
    private Plant plant;
    private Garden myGarden;


    //MODIFIES: this
    //EFFECTS: creates the seedling genus selection screen
    public void seedling(Garden myGarden) {
        this.plant = new Plant();
        this.myGarden = myGarden;
        setUpSeedlingWindow();
        setUpMainButtons();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - seedlingWindow.getWidth()) / 2;
        int y = (screenSize.height - seedlingWindow.getHeight()) / 2;
        seedlingWindow.setLocation(x, y);
        seedlingWindow.setVisible(true);

        this.seedlingWindow.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: creates the main window for the seedling genus choice menu
    public void setUpSeedlingWindow() {

        this.seedlingWindow = new JFrame("Seedling menu");
        seedlingWindow.setSize(725, 625);
        seedlingWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seedlingWindow.setLayout(null);

        textLabel = new JLabel("Select one of the following actions!");
        textLabel.setFont(regFont);
        textLabel.setForeground(Color.black);

        mainPanel = new JPanel();
        mainPanel.setBounds((seedlingWindow.getWidth() / 2) - 300, 100, 600, 500);
        mainPanel.add(textLabel);

        this.seedlingWindow.setResizable(false);
        this.seedlingWindow.add(mainPanel);

    }


    //MODIFIES: this
    //EFFECTS: sets up the main buttons and button panel to be placed on the main window
    public void setUpMainButtons() {

        buttonPanel = new JPanel();
        buttonPanel.setBounds((seedlingWindow.getWidth() / 2) - 150,400,300,100);

        lilyButton = new JButton("lily");
        lilyButton.addActionListener(this);
        ficusButton = new JButton("ficus");
        ficusButton.addActionListener(this);
        anthuriumButton = new JButton("anthurium");
        anthuriumButton.addActionListener(this);

        buttonPanel.add(lilyButton);
        buttonPanel.add(ficusButton);
        buttonPanel.add(anthuriumButton);

        this.seedlingWindow.add(buttonPanel);
    }

    //MODIFIES: this
    //EFFECTS: handles the action of the plant genus button selection being chosen
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == lilyButton) {
            plant.setGenus("lily");
            this.seedlingWindow.setVisible(false);
            new PlantCareMenu().careMenu(plant, myGarden);
        } else if (e.getSource() == ficusButton) {
            plant.setGenus("ficus");
            this.seedlingWindow.setVisible(false);
            new PlantCareMenu().careMenu(plant, myGarden);
        } else if (e.getSource() == anthuriumButton) {
            plant.setGenus("anthurium");
            this.seedlingWindow.setVisible(false);
            new PlantCareMenu().careMenu(plant, myGarden);
        }
    }
}
