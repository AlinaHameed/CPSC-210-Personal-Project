package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {
    private Plant testPlant;
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
        assertEquals(MAX_GROWTH, testPlant.getWater());                       //gets to max growth
        testPlant.watering(testPlant);
        assertEquals(MAX_GROWTH, testPlant.getWater());                       //will not surpass max growth
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
        assertEquals(MAX_GROWTH, testPlant.getSunshine());                    //gets to max growth
        testPlant.sun(testPlant);
        assertEquals(MAX_GROWTH, testPlant.getSunshine());                    // will not surpass max growth

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

    @Test
    void testGetGenus() {
        testPlant.setGenus("lily");
        assertEquals("lily",testPlant.getGenus());
    }
}


