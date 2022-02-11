package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {
    private Plant testPlant;
    private ArrayList<String> testGarden;
    private static int MAX_GROWTH = 3;

    @BeforeEach
    void runBefore() {
        testPlant = new Plant();
    }

    @Test
    void testConstructor() {
        assertEquals("", testPlant.getGenus());
        assertEquals(0, testPlant.getWater());
        assertEquals(0, testPlant.getSunshine());
    }

    @Test
    void testWatering() {
        testPlant.watering(testPlant);
        assertEquals(1, testPlant.getWater());
        testPlant.watering(testPlant);
        assertEquals(2, testPlant.getWater());

        for (testPlant.getWater(); testPlant.getWater() < MAX_GROWTH; ) {
            testPlant.watering(testPlant);
        }
        assertEquals(MAX_GROWTH, testPlant.getWater());
        testPlant.watering(testPlant);
        assertEquals(MAX_GROWTH, testPlant.getWater());
    }

    @Test
    void testSun() {
        testPlant.sun(testPlant);
        assertEquals(1, testPlant.getSunshine());
        testPlant.sun(testPlant);
        assertEquals(2, testPlant.getSunshine());

        for (testPlant.getSunshine(); testPlant.getSunshine() < MAX_GROWTH; ) {
            testPlant.sun(testPlant);
        }
        assertEquals(MAX_GROWTH, testPlant.getSunshine());
        testPlant.sun(testPlant);
        assertEquals(MAX_GROWTH, testPlant.getSunshine());

    }

    @Test
    void testGetWater() {
        assertEquals(0, testPlant.getWater());

        testPlant.watering(testPlant);
        assertEquals(1, testPlant.getWater());

        testPlant.watering(testPlant);
        assertEquals(2, testPlant.getWater());

        for (testPlant.getWater(); testPlant.getWater() < MAX_GROWTH; ) {
            testPlant.watering(testPlant);
        }
        assertEquals(MAX_GROWTH, testPlant.getWater());
        testPlant.watering(testPlant);
        assertEquals(MAX_GROWTH, testPlant.getWater());


    }

    @Test
    void testGetSunshine() {
        assertEquals(0, testPlant.getSunshine());
        testPlant.sun(testPlant);
        assertEquals(1, testPlant.getSunshine());
        testPlant.sun(testPlant);
        assertEquals(2, testPlant.getSunshine());

        for (testPlant.getSunshine(); testPlant.getSunshine() < MAX_GROWTH; ) {
            testPlant.sun(testPlant);
        }
        assertEquals(MAX_GROWTH, testPlant.getSunshine());
        testPlant.sun(testPlant);
        assertEquals(MAX_GROWTH, testPlant.getSunshine());

    }

    @Test
    void testSetGenus() {
        String selected = "lily";
        testPlant.setGenus(selected);
        assertEquals("lily", testPlant.getGenus());

        selected = "anthurium";
        testPlant.setGenus(selected);
        assertEquals("anthurium", testPlant.getGenus());

        selected = "ficus";
        testPlant.setGenus(selected);
        assertEquals("ficus", testPlant.getGenus());
    }
}


