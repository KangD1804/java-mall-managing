package Parking;

public abstract class ParkingSlot {
    protected double fee;

    public abstract void calculateFee(int duration);

    public double getFee() {
        return fee;
    }
}
