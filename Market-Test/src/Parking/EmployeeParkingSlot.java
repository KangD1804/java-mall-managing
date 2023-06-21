package Parking;

public class EmployeeParkingSlot extends ParkingSlot {
    @Override
    public void calculateFee(int duration) {
        // calculate the fee for an employee parking slot based on a monthly rate
        fee = 50;
    }
}