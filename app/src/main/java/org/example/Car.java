package org.example;

public class Car extends Vehicle implements Rentable {
    private boolean isElectric;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isElectric) {
        super(vehicleId, model, baseRentalRate);
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }

    @Override
    public double calculateRentalCost(int days) {
        return super.getBaseRentalRate() * days + (isElectric ? 100 : 0);
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    @Override
    public void rent(Customer cc, int days) {
        if (isAvailableForRental() && cc.checkAge()) {
            super.setIsAvailable(false);
            System.out.println(super.getVehicleId() + " rented to " + cc.getName());
        } else{
            System.out.println("Car already rented or Invalid age");
        }
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
    }
}
