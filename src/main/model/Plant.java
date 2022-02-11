package model;

import java.util.ArrayList;
import java.util.LinkedList;

//represents a plant with a name, age, if the plant has been watered and if the plant is mature
public class Plant {
    private String genus;                    // the genus (type) of plant
    private int watered;                     // how many times a plant has been watered
    private int sunshine;                    // how much sun the plant has received
    private boolean mature;                  // if the plant's age >= MAX_GROWTH true else false
    private static int MAX_GROWTH = 3;       // the value that watered and
    // sunshine must both be to make mature enough to be sent to garden
    private ArrayList<String> gardenPlants;  // the collection of mature plants

    // EFFECTS: the name is set to the name given; the plant type is set to type
    public Plant() {
        this.genus = "";
        this.watered = 0;
        this.sunshine = 0;
        this.gardenPlants = new ArrayList<String>();
    }


    //REQUIRES: to be called on a plant with the max growth of sunshine and water
    //MODIFIES: this
    //EFFECTS: sends plants with max growth of sunshine and water to the garden
    public void sendToGarden(Plant seedling) {
        gardenPlants.add(seedling.genus);
    }

    //REQUIRES: to be called on a plant
    //MODIFIES: this
    //EFFECTS: increments the watered by 1 when watered is < MAX_GROWTH else no incrementation
    public void watering(Plant seedling) {
        if (seedling.watered < MAX_GROWTH) {
            ++seedling.watered;
        }
    }

    //REQUIRES: to be called on a plant
    //MODIFIES: this
    //EFFECTS: increments the sunshine by 1 when watered is < MAX_GROWTH else no incrementation
    public void sun(Plant seedling) {
        if (seedling.sunshine < MAX_GROWTH) {
            ++sunshine;
        }
    }

    //EFFECTS: checks if plant has MAX GROWTH of sunshine and water
    public boolean checkMaxGrowth(Plant seedling) {
        return seedling.getWater() == MAX_GROWTH && seedling.getSunshine() == MAX_GROWTH;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String userGenus) {
        genus = userGenus;
    }

    public int getWater() {
        return this.watered;
    }

    public int getSunshine() {
        return this.sunshine;
    }
}
