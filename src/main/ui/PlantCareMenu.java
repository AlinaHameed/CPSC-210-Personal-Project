package ui;

import model.Garden;
import model.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class PlantCareMenu implements ActionListener {


    private static int MAX_GROWTH = 3;
    private JFrame careWindow;
    private JLabel textLabel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton waterButton;
    private JButton sunButton;
    private Font titleFont = new Font("Monospaced", Font.BOLD, 40);
    private Font regFont = new Font("Times New Roman", Font.PLAIN, 20);

    private Plant plant;
    private Garden myGarden;

    //MODIFIES: this
    //EFFECTS: runs the plant care menu
    public void careMenu(Plant plant, Garden myGarden) {
        this.plant = plant;
        this.myGarden = myGarden;
        setUpCareWindow();
        setUpMainButtons();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - careWindow.getWidth()) / 2;
        int y = (screenSize.height - careWindow.getHeight()) / 2;
        careWindow.setLocation(x, y);
        careWindow.setVisible(true);

        this.careWindow.setVisible(true);

    }


    //MODIFIES: this
    //EFFECTS: creates the main window for care
    public void setUpCareWindow() {

        this.careWindow = new JFrame("Plant care");
        careWindow.setSize(725, 625);
        careWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        careWindow.setLayout(null);

        textLabel = new JLabel("Seedling has been chosen! Select one of the following actions!");
        textLabel.setFont(regFont);
        textLabel.setForeground(Color.black);

        mainPanel = new JPanel();
        mainPanel.setBounds(((careWindow.getWidth()) / 2) - 300, 100, 600, 500);
        mainPanel.add(textLabel);

        this.careWindow.add(mainPanel);
    }

    //MODIFIES: this
    //EFFECTS: creates buttons and button panels to be added to the main window
    public void setUpMainButtons() {

        buttonPanel = new JPanel();
        buttonPanel.setBounds((careWindow.getWidth() / 2) - 150, 400, 300, 100);

        sunButton = new JButton("sun");
        sunButton.addActionListener(this);
        waterButton = new JButton("water");
        waterButton.addActionListener(this);

        buttonPanel.add(sunButton);
        buttonPanel.add(waterButton);

        this.careWindow.add(buttonPanel);
    }

    //MODIFIES: this
    //EFFECTS: increments the plant's sun to the MAX GROWTH
    private void sunAction() {
        if (plant.getSunshine() < MAX_GROWTH) {
            plant.sun(plant);
            textLabel.setText("Good Job! You gave the plant sun " + plant.getSunshine() + " times");
        } else if (plant.getSunshine() == MAX_GROWTH) {
            if (plant.getWater() == MAX_GROWTH) {
                this.myGarden.addPlantToGarden(plant);
                new MainMenuGUI().createGUI(this.myGarden);
                this.careWindow.setVisible(false);
            }
            textLabel.setText("Try giving the plant some water instead");
        }
    }

    //MODIFIES: this
    //EFFECTS: increments the plants water to MAX GROWTH
    private void waterAction() {
        if (plant.getWater() < MAX_GROWTH) {
            plant.watering(plant);
            textLabel.setText("Good Job! You watered the plant " + plant.getWater() + " times");
        } else if (plant.getWater() == MAX_GROWTH) {
            if (plant.getSunshine() == MAX_GROWTH) {
                this.myGarden.addPlantToGarden(plant);
                new MainMenuGUI().createGUI(this.myGarden);
                this.careWindow.setVisible(false);
            }
            textLabel.setText("Try letting the plant get some sun instead");
        }
    }

    //EFFECTS: handles the action events of the sun and water buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sunButton) {
            sunAction();
        } else if (e.getSource() == waterButton) {
            waterAction();
        }
    }
}
