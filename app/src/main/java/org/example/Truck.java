package org.example;

public class Truck extends Vehicle implements Rentable {
    private int doubleTanks = 100;

    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    public int getDoubleTanks() {
        return doubleTanks;
    }

    @Override
    public double calculateRentalCost(int days) {
        return super.getBaseRentalRate() * days + doubleTanks;
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
            System.out.println("Truck already rented or Invalid age");
        }
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
    }
}

