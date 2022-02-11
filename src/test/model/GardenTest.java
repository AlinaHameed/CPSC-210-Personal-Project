package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class GardenTest {
    private Garden testGarden;
    private Plant testPlant;

    @BeforeEach
    void runBefore() {
        testGarden = new Garden();
        testPlant = new Plant();
    }

    @Test
    void testSentToGarden() {
        testPlant.setGenus("lily");
        testGarden.sendToGarden(testPlant);
        assertEquals("lily", testGarden.getIndexPlant(0).getGenus());
        assertEquals(1, testGarden.getNumPlants());
    }
}

