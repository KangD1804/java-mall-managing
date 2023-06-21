package Employee;

public class FullTimeEmployee extends Employee {
    private int salary;
    private boolean isRegisteredParkingSlot;
    private String vehicle;
    private int restDay;
    private final int workDay = 22;
    public FullTimeEmployee(String name, String department,String vehicle, boolean isRegisteredParkingSlot, int restDay, int salary) {
        super(name, department);
        this.salary = salary;
        this.vehicle = vehicle;
        this.isRegisteredParkingSlot = isRegisteredParkingSlot;
        this.restDay = restDay;
    }

    public String getVehicle() {
        return vehicle;
    }

    public boolean isRegisteredParkingSlot() {
        return isRegisteredParkingSlot;
    }

    public int getSalary() {
        return salary;
    }

    public int salaryPerDay(){
        return salary/workDay;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setRegisteredParkingSlot(boolean registeredParkingSlot) {
        isRegisteredParkingSlot = registeredParkingSlot;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getRestDay() {
        return restDay;
    }

    public void setRestDay(int restDay) {
        this.restDay = restDay;
    }

    public int getWorkDay() {
        return workDay;
    }

    @Override
    public int calculateSalary() {
        return salary-(this.salaryPerDay()*restDay);
    }
}