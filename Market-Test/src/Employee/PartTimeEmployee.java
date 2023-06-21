package Employee;

public class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int shift;
    private boolean isRegisteredParkingSlot;
    private String vehicle;

    public  PartTimeEmployee(String name, String department,String vehicle, boolean isRegisteredParkingSlot,int hourlyRate, int shift) {
        super(name, department);
        this.hourlyRate = hourlyRate;
        this.shift = shift;
        this.vehicle = vehicle;
        this.isRegisteredParkingSlot = isRegisteredParkingSlot;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getShift() {
        return shift;
    }

    public String getVehicle() {
        return vehicle;
    }

    public boolean isRegisteredParkingSlot() {
        return isRegisteredParkingSlot;
    }

    @Override
    public int calculateSalary() {
        return hourlyRate * 4 * shift;
    }
}
