package ui;

import model.Garden;
import model.Plant;
import persistence.JsonReader;
import persistence.JsonWriter;

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


    public void seedling(Garden myGarden) {
        this.plant = new Plant();
        this.myGarden = myGarden;
        setUpSeedlingWindow();
        setUpMainButtons();
        this.seedlingWindow.setVisible(true);
    }

    public void setUpSeedlingWindow() {

        this.seedlingWindow = new JFrame("Seedling menu");
        seedlingWindow.setSize(800, 600);
        seedlingWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seedlingWindow.setLayout(null);

        textLabel = new JLabel("Select one of the following actions!");
        textLabel.setFont(regFont);
        textLabel.setForeground(Color.black);

        mainPanel = new JPanel();
        mainPanel.setBounds(100, 100, 600, 500);
        mainPanel.add(textLabel);

        this.seedlingWindow.add(mainPanel);

    }


    public void setUpMainButtons() {

        buttonPanel = new JPanel();
        buttonPanel.setBounds(250,400,300,100);

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
