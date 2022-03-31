package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class GardenTest {
    private Garden testGarden;
    private Plant testPlant;
    private Plant testPlant2;
    private Event allPlants;
    private Event lAndAEvent;
    private Event fAndAEvent;
    private Event ficusEvent;
    private Event lilyEvent;
    private Event anthuriumEvent;
    private Event emptyEvent;

    @BeforeEach
    void runBefore() {
        testGarden = new Garden("Alina's garden");
        testPlant = new Plant();
        testPlant2 = new Plant();
        allPlants = new Event("garden checked to contain type: lily, ficus and anthurium");
        lAndAEvent = new Event("garden checked to contain type: lily and anthurium");
        fAndAEvent = new Event("garden checked to contain type: ficus and anthurium");
        ficusEvent = new Event("garden checked to contain type: ficus");
        lilyEvent = new Event("garden checked to contain type: lily");
        anthuriumEvent = new Event("garden checked to contain type: anthurium");
        emptyEvent = new Event("garden check to be empty");
    }

    @Test
    void testConstructor() {
        assertEquals(0, testGarden.getNumPlants());
        assertEquals("Alina's garden", testGarden.getName());
    }

    @Test
    void testGetNumPlants() {
        assertEquals(0, testGarden.getNumPlants());
        testGarden.addPlantToGarden(testPlant);
        assertEquals(1, testGarden.getNumPlants());
    }

    @Test
    void testGetNumPlantsForSize(){
        assertEquals(0, testGarden.getNumPlants());
        testGarden.addPlantToGarden(testPlant);
        assertEquals(1, testGarden.getNumPlants());
    }


    @Test
    void testGetIndexPlant() {
        testGarden.addPlantToGarden(testPlant);
        assertEquals(testPlant, testGarden.getIndexPlant(0));
        testGarden.addPlantToGarden(testPlant2);
        assertEquals(testPlant, testGarden.getIndexPlant(0));
        assertEquals(testPlant2, testGarden.getIndexPlant(1));
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
        assertEquals(testPlant, testGarden.getIndexPlant(0));
        testGarden.addPlantToGarden(testPlant2);
        assertEquals(testPlant, testGarden.getIndexPlant(0));
        assertEquals(testPlant2, testGarden.getIndexPlant(1));
    }

    @Test
    void testGetName() {
        assertEquals("Alina's garden", testGarden.getName());
    }

    @Test
    void testLogGenus() {
        assertEquals("garden checked to contain type: lily, ficus and anthurium", allPlants.getDescription());
        assertEquals("garden checked to contain type: lily and anthurium",lAndAEvent.getDescription());
        assertEquals("garden checked to contain type: ficus and anthurium",fAndAEvent.getDescription());
        assertEquals("garden checked to contain type: ficus",ficusEvent.getDescription());
        assertEquals("garden checked to contain type: lily",lilyEvent.getDescription());
        assertEquals("garden checked to contain type: anthurium",anthuriumEvent.getDescription());
        assertEquals("garden check to be empty",emptyEvent.getDescription());
    }
}


