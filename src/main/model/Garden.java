package model;

import java.util.ArrayList;

// Represents a garden which will hold all cases of Plants that have been successfully risen by the user
public class Garden {
    private ArrayList<Plant> gardenPlants;   //list of fully grown Plants that have been sent to the garden

    //EFFECTS: makes a garden with no plants in it
    public Garden() {
        this.gardenPlants = new ArrayList<>();
    }

    public int getNumPlants() {
        return gardenPlants.size();
    }

    public Plant getIndexPlant(int index) {
        return gardenPlants.get(index);
    }

    //REQUIRES: to be called on a plant with the max growth of sunshine and water
    //MODIFIES: this
    //EFFECTS: sends plants with max growth of sunshine and water to the garden
    public void sendToGarden(Plant seedling) {
        gardenPlants.add(seedling);
    }
}
