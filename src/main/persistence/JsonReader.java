package persistence;

import model.Garden;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Plant;
import org.json.*;

// Represents a reader that reads garden from JSON data stored in file used the edX JsonSerializationDemo as a base to
// use understand and template JsonReader
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads garden from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Garden read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGarden(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses garden from JSON object and returns it
    private Garden parseGarden(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Garden garden = new Garden(name);
        addPlants(garden, jsonObject);
        return garden;
    }

    // MODIFIES: garden
    // EFFECTS: parses plants from JSON object and adds them to garden
    private void addPlants(Garden garden, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("gardenPlants");
        for (Object json : jsonArray) {
            JSONObject nextPlant = (JSONObject) json;
            addPlant(garden, nextPlant);
        }
    }

    // MODIFIES: garden
    // EFFECTS: parses plant from JSON object and adds it to garden
    private void addPlant(Garden garden, JSONObject jsonObject) {
        String genus = jsonObject.getString("genus");
        Plant plant = new Plant();
        plant.setGenus(genus);
        garden.addPlantToGarden(plant);
    }
}


