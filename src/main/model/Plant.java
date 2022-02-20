package model;

import java.util.ArrayList;

//represents a plant with a genus name, how much water and sunshine the plant has received
// from the respectively watered and sunshine and, a constant of MAX_GROWTH to decern how much water
// and sunshine the plant needs until fully grown.
public class Plant {
    private String genus;                    // the genus (type) of plant
    private int watered;                     // how many times a plant has been watered
    private int sunshine;                    // how much sun the plant has received
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
