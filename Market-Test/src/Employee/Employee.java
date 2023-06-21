package Employee;

public abstract class Employee {
    private String name;
    private String department;
    private String vehicle;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public abstract int calculateSalary();

    public String getVehicle() {
        return vehicle;
    }

    public abstract boolean isRegisteredParkingSlot();
}
