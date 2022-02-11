package model;

import java.util.LinkedList;

public class Garden {
    private String name;                      // the name of the garden
    private LinkedList<Plant> gardenPlants;   // list of all the plants that have been sent to this garden
    private String time;                      // if it is day or night at the garden

    //EFFECTS: names the garden and creates a new empty list
    public Garden() {
        this.name = "UBC Botanical Garden";
        this.gardenPlants = new LinkedList<Plant>();
        this.time = "daytime";
    }

    public void changeTime(Garden garden) {
        if (time == "daytime") {
            this.time = "nighttime";
        } else {
            this.time = "daytime";
        }
    }

    public LinkedList<Plant> getGardenPlants() {
        return gardenPlants;
    }
}