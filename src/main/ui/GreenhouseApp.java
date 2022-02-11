package ui;

import model.Plant;
import model.Garden;

import java.util.ArrayList;
import java.util.Scanner;

// Greenhouse game application
public class GreenhouseApp {
    private Plant seedling;
    private ArrayList<String> gardenPlants;
    private Scanner input;
    private static int MAX_GROWTH = 3;

    // EFFECTS: runs the teller application
    public GreenhouseApp() {
        runGreenhouse();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGreenhouse() {
        boolean keepGoing = true;
        String command = null;

        init();
        displayMenu();

        while (keepGoing) {
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye for now, Thank you for Playing!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command as given from the display menu
    private void processCommand(String command) {
        if (command.equals("seedling")) {
            makePlant();
            while (seedling.getWater() < MAX_GROWTH) {
                takeCareOfPlantOptions();
            }
            while (seedling.getSunshine() < MAX_GROWTH) {
                takeCareOfPlantOptions();
            }
            sendNewPlantToGarden(seedling);
        } else if (command.equals("garden")) {
            goGarden("");
        } else {
            System.out.println("Selection not valid please try again!");
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes a plant without a genus and UBC garden
    private void init() {
        seedling = new Plant();
        gardenPlants = new ArrayList<String>();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect by type one of the following:");
        System.out.println("\tseedling -> to start raising a new seedling");
        System.out.println("\tgarden   -> go to the Botanical garden");
        System.out.println("\tquit     -> to leave the game");
    }

    // MODIFIES: this
    // EFFECTS: make a plant with the selected genus
    private void makePlant() {
        System.out.print("\nWould you like to grow a lily, ficus or anthurium?");
        selectGenus();
        System.out.println("good choice!");

        System.out.println("\nNow that you have a plant, it's time to rake care of it");

        System.out.print("Let's water the plant to make it grow!");
        takeCareOfPlantOptions();
    }

    // EFFECTS: prompts user to select a plant type
    private void selectGenus() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("l") || selection.equals("f") || selection.equals("a"))) {
            System.out.println("\n\tl for lily");
            System.out.println("\tf for ficus");
            System.out.println("\ta for anthurium");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("l")) {
            seedling.setGenus("lily");
        }
        if (selection.equals("f")) {
            seedling.setGenus("ficus");
        } else {
            seedling.setGenus("anthurium");
        }
    }

    private void takeCareOfPlantOptions() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("w") || selection.equals("s"))) {
            System.out.println("\nSelect an action");
            System.out.println("\n\tw -> give your plant a drink of water!");
            System.out.println("\ts -> help your plant photosynthesize with some sunshine!");
            selection = input.next();
            selection = selection.toLowerCase();
            takeCareOfPlantActions(selection);
        }
    }

    private void takeCareOfPlantActions(String selection) {
        if (selection.equals("w") && seedling.getWater() < MAX_GROWTH) {
            seedling.watering(seedling);
            System.out.println("good job!");

        } else if (selection.equals("s") && seedling.getSunshine() < MAX_GROWTH) {
            seedling.sun(seedling);
            System.out.println("good job!");

        } else if (selection.equals("s") && seedling.getSunshine() == MAX_GROWTH) {
            System.out.println("try giving the plant some water instead");

        } else if (selection.equals("w") && seedling.getWater() == MAX_GROWTH) {
            System.out.println("try letting the plant get some sun instead");

        } else {
            System.out.println("try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: prompts user to choose what they want to do in the garden
    private void goGarden(String command) {
        String selection = "";  // force entry into loop

        while (!(selection.equals("p") || selection.equals("s"))) {
            System.out.println("\nWelcome to the garden! what would you like to do?");
            System.out.println("\tp -> see all the plants you have sent to the garden!");
            System.out.println("\ts -> see the total number of plants you have sent to the garden!");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("p")) {
            gardenPlants.toString();
        }
        if (selection.equals("s")) {
            gardenPlants.size();
        }
    }

    private void sendNewPlantToGarden(Plant seedling) {
        System.out.println(
                "Your plant is too big to stay in the greenhouse! it's time visit the garden and drop off your plant!"
        );
        Garden.sendToGarden(seedling);
        goGarden("");
    }

}



