package ui;

import model.Garden;
import model.Plant;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartScreen implements ActionListener {

    private JFrame startWindow;
    private JPanel welcomePanel;
    private JPanel startButtonPanel;
    private JLabel titleNameLabel;
    private JButton startButton;
    private Font titleFont = new Font("Monospaced", Font.BOLD, 40);
    private Font regFont = new Font("Times New Roman", Font.PLAIN, 20);

    private Garden myGarden;


    //EFFECTS: creates the starting screen for the application
    public StartScreen() {
        this.myGarden = new Garden("User Garden");
        setUpStartWindow();
        setUpStartButton();
        startWindow.setVisible(true);
    }

    //EFFECTS: creates the
    public void setUpStartWindow() {
        this.startWindow = new JFrame("Floral Tamagotchi");
        startWindow.setSize(800, 600);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startWindow.setLayout(null);


        titleNameLabel = new JLabel("Floral Tamagotchi");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.black);

        welcomePanel = new JPanel();
        welcomePanel.setBounds(100, 100, 600, 500);
        welcomePanel.add(titleNameLabel);

        this.startWindow.add(welcomePanel);
    }


    public void setUpStartButton() {
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);

        startButton = new JButton("Start!");
        startButton.addActionListener(this);
        startButton.setFont(regFont);
        startButtonPanel.add(startButton);

        this.startWindow.add(startButtonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startWindow.setVisible(false);
        new MainMenuGUI().createGUI(myGarden);

    }
}
