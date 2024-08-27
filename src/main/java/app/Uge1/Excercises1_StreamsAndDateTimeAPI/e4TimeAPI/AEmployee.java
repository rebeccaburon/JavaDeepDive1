package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e4TimeAPI;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AEmployee {
    private String name;
    private int age;
    private String department;
    private double salary;
    private LocalDate birthdate;

    // Constructor
    public AEmployee(String name, int age, String department, double salary, LocalDate birthdate) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", birthdate=" + birthdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                '}';
    }

    // Calculate age based on birthdate
    public int calculateAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}