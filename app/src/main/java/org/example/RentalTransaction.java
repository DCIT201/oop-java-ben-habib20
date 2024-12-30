package org.example;

public class RentalTransaction {
    private String transactionId;
    private Customer customer;
    private Vehicle vehicle;
    boolean isCompleted;

    public RentalTransaction(String transactionId, Customer customer, Vehicle vehicle) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.isCompleted = false;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted () {
        isCompleted = true;
        vehicle.returnVehicle();
    }

    @Override
    public String toString() {
        return "TransactionId: " + getTransactionId() + '\n' + "Customer: " + customer.getName() + '\n' + "Vehicle: " + vehicle.getModel()
                + '\n' + "Status: " + (isCompleted ? "Returned" : "Not returned");
    }
}
