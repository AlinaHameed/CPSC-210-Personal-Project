package model;

import java.util.LinkedList;

//represents a plant with a name, age, if the plant has been watered and if the plant is mature
public class Plant {
    private String genus;                    // the genus (type) of plant
    private int watered;                     // how many times a plant has been watered
    private int sunshine;                    // how much sun the plant has received
    private boolean mature;                  // if the plant's age >= MAX_GROWTH true else false
    private static int MAX_GROWTH = 3;       // the value that watered and
    // sunshine must both be to make mature enough to be sent to garden
    private LinkedList<Plant> gardenPlants;  // the collection of mature plants

    // EFFECTS: the name is set to the name given; the plant type is set to type
    public Plant() {
        this.genus = "";
        this.watered = 0;
        this.sunshine = 0;
        this.gardenPlants = new LinkedList<Plant>();
    }

    //REQUIRES: to be called on a plant
    //MODIFIES: this
    //EFFECTS: increments the watered by 1 when watered is < MAX_GROWTH else no incrementation
    public void watering(Plant seedling) {
        if (watered == MAX_GROWTH && sunshine == MAX_GROWTH) {
            System.out.println("your plant is too big for the green house, let's send it to the gardens!");
            gardenPlants.add(seedling);
        } else if (watered == MAX_GROWTH && !(sunshine == MAX_GROWTH)) {
            System.out.println("Try giving your plant some sun instead!");
        } else {
            ++watered;
        }
    }

    //REQUIRES: to be called on a plant with the max growth of sunshine and water
    //MODIFIES: this
    //EFFECTS: sends plants with max growth of sunshine and water to the garden
    public void sendToGarden(Plant seedling) {
        gardenPlants.add(seedling);
    }


    //REQUIRES: to be called on a plant
    //MODIFIES: this
    //EFFECTS: increments the sunshine by 1 when watered is < MAX_GROWTH else no incrementation
    public void sun(Plant seedling) {
        if (watered == MAX_GROWTH && sunshine == MAX_GROWTH) {
            System.out.println("your plant is too big for the green house, let's send it to the gardens!");
            gardenPlants.add(seedling);
        } else if (sunshine == MAX_GROWTH && !(watered == MAX_GROWTH)) {
            System.out.println("Try giving your plant some water instead!");
        } else {
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
