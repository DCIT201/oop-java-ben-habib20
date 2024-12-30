package org.example;

public class Motocycle extends Vehicle implements Rentable {
    private int bootsCost = 87;

    public Motocycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    public int getBootsCost() {
        return bootsCost;
    }

    @Override
    public double calculateRentalCost(int days) {
        return super.getBaseRentalRate() * days + bootsCost;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkAge()) {
            setIsAvailable(false);
            System.out.println(super.getVehicleId() + " rented to " + customer.getName());
        } else{
            System.out.println("Motocycle already rented or Invalid age");
        }
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
    }
}

