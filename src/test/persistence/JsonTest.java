package persistence;

import model.Plant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlant(String name, Plant plant) {
        assertEquals(name, plant.getGenus());
    }
}
