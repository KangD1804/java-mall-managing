package Parking;

public class CustomerParkingSlot extends ParkingSlot {
    @Override
    public void calculateFee(int duration) {
        // calculate the fee for a customer parking slot based on an hourly rate
        fee = duration * 5;
    }
}