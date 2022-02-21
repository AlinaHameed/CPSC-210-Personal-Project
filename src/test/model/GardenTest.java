package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GardenTest {
    private Garden testGarden;
    private Plant testPlant;
    private Plant testPlant2;

    @BeforeEach
    void runBefore() {
        testGarden = new Garden("Alina's garden");
        testPlant = new Plant();
        testPlant2 = new Plant();
    }

    @Test
    void testConstructor() {
        assertEquals(0,testGarden.getNumPlants());
        assertEquals("Alina's garden",testGarden.getName());
    }

    @Test
    void testGetNumPlants() {
        assertEquals(0,testGarden.getNumPlants());
        testGarden.addPlantToGarden(testPlant);
        assertEquals(1,testGarden.getNumPlants());
    }

    @Test
    void testGetIndexPlant() {
        testGarden.addPlantToGarden(testPlant);
        assertEquals(testPlant,testGarden.getIndexPlant(0));
        testGarden.addPlantToGarden(testPlant2);
        assertEquals(testPlant,testGarden.getIndexPlant(0));
        assertEquals(testPlant2,testGarden.getIndexPlant(1));
    }

    @Test
    void testSentToGarden() {
        testPlant.setGenus("lily");
        testGarden.sendToGarden(testPlant);
        assertEquals("lily", testGarden.getIndexPlant(0).getGenus());
        assertEquals(1, testGarden.getNumPlants());


        testPlant2.setGenus("ficus");
        testGarden.sendToGarden(testPlant2);
        assertEquals("lily", testGarden.getIndexPlant(0).getGenus());
        assertEquals("ficus", testGarden.getIndexPlant(1).getGenus());
        assertEquals(2, testGarden.getNumPlants());

    }

    @Test
    void testAddingPlantToGarden() {
        testGarden.addPlantToGarden(testPlant);
        assertEquals(testPlant,testGarden.getIndexPlant(0));
        testGarden.addPlantToGarden(testPlant2);
        assertEquals(testPlant,testGarden.getIndexPlant(0));
        assertEquals(testPlant2,testGarden.getIndexPlant(1));
    }

    @Test
    void testGetName() {
        assertEquals("Alina's garden", testGarden.getName());
    }
}

