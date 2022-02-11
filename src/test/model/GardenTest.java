package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GardenTest {

    private Garden testGarden;

    @BeforeEach
    void runBefore() {
        testGarden = new Garden();
    }
}
