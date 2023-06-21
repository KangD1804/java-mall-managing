package Employee;

import Parking.ParkingSlotFactory;

public class EmployeeFactory {
    public static Employee createEmployee(String type, String name, String department, String vehicle, boolean isRegisteredParkingSlot, int ... args) {
        if (type.equalsIgnoreCase("fulltime")) {
            FullTimeEmployee employee = new FullTimeEmployee    (name, department, vehicle,isRegisteredParkingSlot,args[0], args[1]);
            EmployeeDatabase.getInstance().addEmployee(employee);
            ParkingSlotFactory.createParkingSlot("employee");
            return employee;
        } else if (type.equalsIgnoreCase("parttime")) {
            PartTimeEmployee employee = new PartTimeEmployee(name , department, vehicle, isRegisteredParkingSlot, args[0], args[1]);
            EmployeeDatabase.getInstance().addEmployee(employee);
            ParkingSlotFactory.createParkingSlot("employee");
            return employee;
        } else {
            throw new IllegalArgumentException("Invalid employee type: " + type);
        }
    }
}