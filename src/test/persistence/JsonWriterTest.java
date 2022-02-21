package persistence;

import model.Garden;
import model.Plant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    private Plant testPlant;
    private Plant testPlant2;

        @BeforeEach
        void runBefore() {
        testPlant = new Plant();
        testPlant.setGenus("lily");
        testPlant2 = new Plant();
        testPlant2.setGenus("ficus");
    }

    @Test
    void testWriterInvalidFile() {
        try {
            Garden garden = new Garden();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyGarden() {
        try {
            Garden garden = new Garden();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGarden.json");
            writer.open();
            writer.write(garden);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGarden.json");
            garden = reader.read();
            assertEquals(0, garden.getNumPlants());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralGarden() {
        try {
            Garden garden = new Garden();
            garden.addPlant(testPlant);
            garden.addPlant(testPlant2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGarden.json");
            writer.open();
            writer.write(garden);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGarden.json");
            garden = reader.read();
            ArrayList<Plant> plants = garden.getPlants();
            checkPlant("lily", garden.getIndexPlant(0));
            checkPlant("ficus", garden.getIndexPlant(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}