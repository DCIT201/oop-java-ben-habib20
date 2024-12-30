package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    void testCalculateRentalCost() {
        Vehicle car = new Truck("C1", "Toyota", 4.0);
        assertEquals(140.0, car.calculateRentalCost(10));
    }

    @Test
    void testAvailability() {
        Vehicle truck = new Truck("T1", "Ford", 30.0);
        assertTrue(truck.getIsAvailable());
        truck.setIsAvailable(false);
        assertFalse(truck.getIsAvailable());
    }
}

