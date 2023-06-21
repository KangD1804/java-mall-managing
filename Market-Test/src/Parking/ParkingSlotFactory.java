package Parking;

public class ParkingSlotFactory {
    private static final int MAX_CAPACITY = 1000;
    private static int employeeCount = 0;
    private static int customerCount = 0;

    public static ParkingSlot createParkingSlot(String type) {
        if (employeeCount + customerCount <= MAX_CAPACITY) {
            switch (type) {
                case "employee":
                    employeeCount++;
                    return new EmployeeParkingSlot();
                case "customer":
                    customerCount++;
                    return new CustomerParkingSlot();
                default:
                    throw new IllegalArgumentException("Invalid parking slot type");
            }
        } else {
            throw new RuntimeException("Parking lot is full");
        }
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

}