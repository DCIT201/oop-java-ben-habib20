package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCalculateRentalCost() {
        Vehicle car = new Car("C1", "Civic", 100.0, false);
        assertEquals(200.0, car.calculateRentalCost(2));
    }

    @Test
    void testAvailable() {
        Vehicle car = new Car("car1", "Corvette", 10.0, true);
        assertTrue(car.getIsAvailable());
        car.setIsAvailable(false);
        assertFalse(car.getIsAvailable());
    }
}

