package app.Uge1.Excercises2_FunctionalProgramming.e4Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
@ToString
public class Employee implements Serializable {
private String name;
private int age;

    public static List<Employee> populateEmployeeList()
    {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();
        String[] names = {"John", "Jane", "Alex", "Chris", "Taylor", "Jordan", "Morgan", "Casey", "Riley", "Jamie"};

        for (int i = 0; i < 10; i++) {
            String name = names[random.nextInt(names.length)];
            int age = random.nextInt(50) + 20; // Random age between 20 and 70
            employees.add(new Employee(name, age));
        }
        return employees;
    }
}

