package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTransactionTest {
    private RentalTransaction tt;
    private Customer cc;
    private Vehicle vv;

    @BeforeEach
    void setUp() {
        // Create a customer and a vehicle for testing
        cc = new Customer("Loica", 56);
        vv = new Car("car1", "Civic", 10.0, false);
        tt = new RentalTransaction("id1", cc, vv);
    }

    @Test
    void testTransactionInitialization() {
        assertEquals("id1", tt.getTransactionId());
        assertEquals(cc, tt.getCustomer());
        assertEquals(vv, tt.getVehicle());
        assertFalse(tt.isCompleted());
    }

    @Test
    void testSetIsCompleted() {
        tt.setCompleted();
        assertTrue(tt.isCompleted());
        assertTrue(vv.getIsAvailable());
    }
}
