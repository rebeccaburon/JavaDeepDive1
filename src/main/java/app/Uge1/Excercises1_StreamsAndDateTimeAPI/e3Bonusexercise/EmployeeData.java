package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e3Bonusexercise;

import java.util.Arrays;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Alice", 30, "HR", 50000),
                new Employee("Hans", 45, "Finance", 75000),
                new Employee("Mette", 40, "IT", 80000),
                new Employee("Jesper", 35, "IT", 70000),
                new Employee("Anna", 50, "Finance", 90000),
                new Employee("Ib", 25, "HR", 45000),
                new Employee("Vanessa", 29, "Finance", 55000)
        );
    }
}
