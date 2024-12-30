package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotocycleTest {
    @Test
    void testCalculateRentalCost() {
        Vehicle motocycle = new Motocycle("C1", "Sonic", 5.0);
        assertEquals(97.0, motocycle.calculateRentalCost(2));
    }

    @Test
    void testAvailability() {
        Vehicle motorcycle = new Motocycle("M1", "Sonic", 9.0);
        assertTrue(motorcycle.getIsAvailable());
        motorcycle.setIsAvailable(false);
        assertFalse(motorcycle.getIsAvailable());
    }
}

