package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    @Test
    void testRentVehicle() {
        RentalAgency agency = new RentalAgency();
        Vehicle car = new Car("Car1", "Corvette", 50.0, true);
        agency.addVehicle(car);

        Customer customer = new Customer("Loica", 25);
        agency.rentVehicle("Car1", customer, 3);

        assertFalse(car.getIsAvailable());
    }
}
