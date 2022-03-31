package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a garden which will hold all cases of Plants that have been successfully risen by the user
public class Garden implements Writable {
    private ArrayList<Plant> gardenPlants;   //list of fully grown Plants that have been sent to the garden
    private String name;                     // name of the garden

    //EFFECTS: makes a garden with no plants in it
    public Garden(String name) {
        this.gardenPlants = new ArrayList<>();
        this.name = name;
    }

    //EFFECTS: gets the number of plants within garden
    public int getNumPlants() {
        return gardenPlants.size();
    }

    //EFFECTS: gets the number of plants within garden for total plants
    public int getNumPlantsForSize() {
        EventLog.getInstance().logEvent(new Event("Garden size checked to be " + gardenPlants.size()));
        return gardenPlants.size();
    }

    //REQUIRES: to get called on a garden with atleast one plant
    //EFFECTS: gets the plant at a given index from the garden else nothing
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
    // EFFECTS: adds plant to this garden
    public void addPlantToGarden(Plant plant) {
        EventLog.getInstance().logEvent(new Event("Plant with genus " + plant.getGenus() + " added to garden"));
        gardenPlants.add(plant);
    }

    //EFFECTS: returns the garden's name
    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("gardenPlants", gardenPlantsToJson());
        return json;
    }

    //EFFECTS: returns plant in this garden as a JSON array
    private JSONArray gardenPlantsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Plant p : gardenPlants) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

    //EFFECTS: returns a new garden with a copy of the plants from the garden given
    public Garden getPlants() {
        Garden collectionOfPlants = new Garden("Alina's garden");

        for (int i = 0; i < gardenPlants.size(); i++) {
            collectionOfPlants.addPlantToGarden(gardenPlants.get(i));
        }
        return collectionOfPlants;
    }

    //EFFECTS: logs the event of which plants are in the garden
    public void logGenus(Boolean hasFicus, Boolean hasLily, Boolean hasAnthurium) {
        if (hasFicus && hasLily && hasAnthurium) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: lily, ficus and anthurium"));
        } else if (hasFicus && hasLily) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: lily and ficus"));
        } else if (hasLily && hasAnthurium) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: lily and anthurium"));
        } else if (hasAnthurium && hasFicus) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: ficus and anthurium"));
        } else if (hasFicus) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: ficus"));
        } else if (hasLily) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: lily"));
        } else if (hasAnthurium) {
            EventLog.getInstance().logEvent(new Event("garden checked to contain type: anthurium"));
        } else {
            EventLog.getInstance().logEvent(new Event("garden check to be empty"));
        }
    }
}
