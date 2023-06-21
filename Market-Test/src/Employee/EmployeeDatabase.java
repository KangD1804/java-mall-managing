package Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EmployeeDatabase {
    private static EmployeeDatabase instance = null;
    private static Set<Employee> employees;

    private EmployeeDatabase(){
        employees = new HashSet<>();
    }

    public static EmployeeDatabase getInstance(){
        if (instance == null) {
            instance = new EmployeeDatabase();
        }
        return instance;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public int calculateTotalSalary(){
        int totalSalary = 0;
        for(Employee employee : employees){
            if(employee instanceof PartTimeEmployee){
                totalSalary+= employee.calculateSalary();
            }else {
                totalSalary+= employee.calculateSalary();
            }
        }
        return totalSalary;
    }

    public double calculateCarPark() {
        double carFee = 0;
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                if (employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("Car")) {
                    carFee += 30;
                }
            }
        }
        return carFee;
    }
    public double calculateBikePark(){
        double bikeFee = 0;
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                if (employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("Motorbike")) {
                    bikeFee += 30;
                }
            }
        }
        return bikeFee;
    }

    public void exportSalaryPartTime() {
        String filePath = "./parttime_salary.txt";
        FileWriter fileWriter = null;
        try {
            double total = 0;
            fileWriter = new FileWriter(filePath);
            for (Employee employee : employees) {
                if(employee instanceof PartTimeEmployee){
                    total += employee.calculateSalary();
                    fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " : " + employee.calculateSalary()+"\n");
                }
            }
            fileWriter.write("Total full time salaries: " +total);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void exportSalaryFullTime() {
        String filePath = "./fulltime_salary_data.txt";
        FileWriter fileWriter = null;
        try {
            double total = 0;
            fileWriter = new FileWriter(filePath);
            for (Employee employee : employees) {
                if (employee instanceof FullTimeEmployee) {
                    total += employee.calculateSalary();
                    fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " : " + employee.calculateSalary() +" (rest "+((FullTimeEmployee) employee).getRestDay()+" day(s))" +"\n");
                }
            }
            fileWriter.write("Total full time salaries: " +total);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void exportParkingInfo(){
        String filePath = "./parking_data.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            for (Employee employee : employees) {
                if(employee instanceof FullTimeEmployee) {
                    if (employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("motorbike")) {
                        fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " drives " + employee.getVehicle() + " pay 10$ for parking." + "\n");
                    } else if (employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("car")) {
                        fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " drives " + employee.getVehicle() + " pay 30& for parking." + "\n");
                    }
                } else {
                    fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " drives " + employee.getVehicle() + " is parking for free" + "\n");
                }
            }
            fileWriter.write("Total motorbike parking slots revenue from employee: " +this.calculateBikePark() +"\n");
            fileWriter.write("Total car parking slots revenue from employee: " +this.calculateCarPark());

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

}
