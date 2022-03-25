package ui;

import model.Garden;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartScreen implements ActionListener {

    private JFrame startWindow;
    private JPanel welcomePanel;
    private JPanel startButtonPanel;
    private JLabel imgLabel;
    private ImageIcon icon;
    private BufferedImage image;
    private JLabel titleNameLabel;
    private JButton startButton;
    private Font titleFont = new Font("Monospaced", Font.BOLD, 40);
    private Font regFont = new Font("Times New Roman", Font.PLAIN, 20);

    private Garden myGarden;


    //MODIFIES: this
    //EFFECTS: creates the starting screen for the application
    public StartScreen() {
        this.myGarden = new Garden("User Garden");
        setUpStartWindow();
        setUpStartButton();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - startWindow.getWidth()) / 2;
        int y = (screenSize.height - startWindow.getHeight()) / 2;
        startWindow.setLocation(x, y);
        startWindow.setVisible(true);

        startWindow.setVisible(true);
        startWindow.add(new JLabel(new ImageIcon("./resources/GreenhouseImage.png")));
    }

    //MODIFIES: this
    //EFFECTS: creates the startup buffering window with image
    public void setUpStartWindow() {
        this.startWindow = new JFrame("Floral Tamagotchi");
        startWindow.setSize(725, 625);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startWindow.setLayout(null);

        welcomePanel = new JPanel();
        welcomePanel.setSize(800,600);
        welcomePanel.setBounds(-90, 0, 900, 600);

        File file = new File("./resources/GreenhouseImage.png");
        try {
            this.image = ImageIO.read(file);
            Graphics g = image.getGraphics();
            g.setFont(titleFont);
            g.drawString("Floral Tamagotchi", 175,150);

        } catch (IOException e) {
            titleNameLabel.setText("something went wrong!");
        }
        this.icon = new ImageIcon(image);
        imgLabel = new JLabel(icon);

        welcomePanel.add(imgLabel);

        this.startWindow.add(welcomePanel);
    }


    //MODIFIES: this
    //EFFECTS: sets the button panel with the start button to be added to the main panel and window
    public void setUpStartButton() {
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds((startWindow.getWidth() / 2) - 100,400, 200, 100);
        startButtonPanel.setBackground(new Color(28,62,11,65));

        startButton = new JButton("Start!");
        startButton.addActionListener(this);
        startButton.setFont(regFont);
        startButtonPanel.add(startButton);

        this.startWindow.add(startButtonPanel);
    }

    //EFFECTS: sends user to main menu once clicked start
    @Override
    public void actionPerformed(ActionEvent e) {
        startWindow.setVisible(false);
        new MainMenuGUI().createGUI(myGarden);

    }
}
