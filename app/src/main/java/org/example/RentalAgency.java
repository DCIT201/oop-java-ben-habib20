package org.example;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<RentalTransaction> tt;
    private List<Vehicle> vv;

    public RentalAgency() {
        tt = new ArrayList<>();
        vv = new ArrayList<>();
    }

    // Add a vehicle to the agency's fleet
    public void addVehicle(Vehicle veh) {
        vv.add(veh);
    }

    // Rent a vehicle to a customer
    public void rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
            return;
        }

        if (!vehicle.isAvailableForRental()) {
            System.out.println("Vehicle " + vehicle.getModel() + " is not available for rental.");
            return;
        }

        String transactionid = "id" + ((tt.size()) + 1);

        RentalTransaction transaction = new RentalTransaction(transactionid, customer, vehicle);
        tt.add(transaction);

        vehicle.rent(customer, days);
    }

    // Return a rented vehicle
    public void bringVehicle(String transactionId) {
        RentalTransaction transaction = findTransactionById(transactionId);

        if (transaction.isCompleted()) {
            System.out.println("Transaction " + transactionId + " is already completed.");
            return;
        }

        transaction.setCompleted();
        System.out.println("Vehicle returned for transaction: " + transactionId);
    }

    // Helper method to find a vehicle by ID
    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vv) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    // View all transactions
    public void seeTransactions() {
        System.out.println("Rental transactions:");
        for (RentalTransaction transaction : tt) {
            System.out.println(transaction);
        }
    }

    // View all vehicles
    public void seeVehicles() {
        System.out.println("Vehicles in fleet:");
        for (Vehicle veh : vv) {
            System.out.println(veh);
        }
    }

    // Helper method to find a transaction by ID
    public RentalTransaction findTransactionById(String transactionId) {
        for (RentalTransaction transaction : tt) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return transaction;
            }
        }
        return null;
    }
}
