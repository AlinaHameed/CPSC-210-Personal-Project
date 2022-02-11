package model;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private static List<String> gardenPlants; //list of plant genus that have been sent to garden

    //EFFECTS: makes a garden with no plants in it
    public Garden() {
        this.gardenPlants = new ArrayList<>();
    }

    //REQUIRES: to be called on a plant with the max growth of sunshine and water
    //MODIFIES: this
    //EFFECTS: sends plants with max growth of sunshine and water to the garden
    public static void sendToGarden(Plant seedling) {
        gardenPlants.add(seedling.getGenus());
    }
}
