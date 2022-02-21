package ui;

import java.io.FileNotFoundException;

//EFFECTS: runs the greenhouse application
public class Main {
    public static void main(String[] args) {
        try {
            new GreenhouseApp();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry unable to run application, file not found");
        }
    }
}
