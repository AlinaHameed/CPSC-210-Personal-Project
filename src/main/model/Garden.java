package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a garden which will hold all cases of Plants that have been successfully risen by the user
public class Garden implements Writable {
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

    //MODIFIES: this
    // EFFECTS: adds plants to this garden
    public void addPlant(Plant plant) {
        gardenPlants.add(plant);
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("gardenPlants",gardenPlantsToJson());
        return json;
    }

    private JSONArray gardenPlantsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Plant p : gardenPlants) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

    public ArrayList<Plant> getPlants() {
        //stub
        return null;
    }
}
