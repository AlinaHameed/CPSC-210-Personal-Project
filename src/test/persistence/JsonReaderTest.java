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
            assertEquals(0, garden.getNumPlants());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

//    @Test
//    void testReaderGeneralWorkRoom() {
//        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
//        try {
//            Garden garden = reader.read();
//            ArrayList<Plant> plants = garden.getPlants();
//            assertEquals(2, plants.size());
//            checkPlant("lily", garden.getIndexPlant(0));
//            checkPlant("ficus", garden.getIndexPlant(1));
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
}
