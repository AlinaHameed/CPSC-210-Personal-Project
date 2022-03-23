package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Garden;
import model.Plant;

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

    public void garden(Garden userGarden) {
        this.currentGarden = userGarden;
        setUpGardenWindow();
        setUpMainButtons();
        this.gardenWindow.setVisible(true);
    }

    public void setUpGardenWindow() {
        this.gardenWindow = new JFrame("Garden");
        gardenWindow.setSize(800, 600);
        gardenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gardenWindow.setLayout(null);

        textLabel = new JLabel("Welcome to the garden! Select one of the actions");
        textLabel.setFont(regFont);
        textLabel.setForeground(Color.black);

        mainPanel = new JPanel();
        mainPanel.setBounds(100, 100, 600, 500);
        mainPanel.add(textLabel);

        this.gardenWindow.add(mainPanel);
    }

    public void setUpMainButtons() {

        buttonPanel = new JPanel();
        buttonPanel.setBounds(250,400,300,100);

        genusButton = new JButton("which plants are in your garden?");
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


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == genusButton) {
            textLabel.setText("These are the current plant genus types in your garden!");
        } else if (e.getSource() == numberButton) {
            textLabel.setText("You currently have " + this.currentGarden.getNumPlants() + " in your garden!");
        } else if (e.getSource() == returnButton) {
            this.gardenWindow.setVisible(false);
            new MainMenuGUI().createGUI(this.currentGarden);


        }
    }
}
