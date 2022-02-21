package persistence;

import model.Plant;
import model.Garden;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Garden garden = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyGarden() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGarden.json");
        try {
            Garden garden = reader.read();
            assertEquals("My garden",garden.getName());
            assertEquals(0, garden.getNumPlants());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGarden() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGarden.json");
        try {
            Garden garden = reader.read();
            assertEquals("My general garden",garden.getName());
            Garden plants = garden.getPlants();
            assertEquals(2, plants.getNumPlants());
            checkPlant("lily", plants.getIndexPlant(0));
            checkPlant("ficus", plants.getIndexPlant(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

