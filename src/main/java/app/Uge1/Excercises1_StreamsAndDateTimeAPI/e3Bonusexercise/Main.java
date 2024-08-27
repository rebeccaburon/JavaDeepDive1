package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e3Bonusexercise;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Calculate the average age of all employees
        List<Employee> employees = EmployeeData.getEmployees();

        OptionalDouble averageAge = employees.stream()
                // extract the age from each Employee object.
                .mapToInt(Employee::getAge)
                .average();
        // System.out.println("Average Age: " + (averageAge.isPresent() ? averageAge.getAsDouble() : 0));


        //Find the employee with the highest salary

        Optional<Employee> highestPaid = employees.stream()
                //e1 and e2 are placeholder variable names for the two Salary objects that
                // are being compared in each iteration of the stream processing.
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        // highestPaid.ifPresent(e -> System.out.println("Highest Paid: " + e));


        //Group employees by department and calculate the average salary for each department
        Map<String, Double> avgSalaryByDept = employees.stream()
                //  extracts the department from each employee and extract the salary for averaging:
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println("Department: " + dept + ", Average Salary: " + avgSalary));

        //Count the number of employees in each department
        Map<String, Long> employeeCountByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        employeeCountByDept.forEach((dept, count) ->
                System.out.println("Department: " + dept + ", Employee Count: " + count));

        //Find the three oldest employees
        List<Employee> oldestEmployees = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Three Oldest Employees: " + oldestEmployees);


        //Filter and display employees whose salary is above a certain threshold
        double salaryThreshold = 60000;

        List<Employee> highEarners = employees.stream()
                .filter(e -> e.getSalary() > salaryThreshold)
                .collect(Collectors.toList());

        System.out.println("Employees with Salary Above " + salaryThreshold + ": " + highEarners);

        /** Sorting
         * In this area it will be sortet by: Age, Salary and name:
         */
        // Sort by age
        List<Employee> sortedByAge = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .collect(Collectors.toList());

        System.out.println("Employees Sorted by Age: " + sortedByAge);

        // Sort by salary
        List<Employee> sortedBySalary = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .collect(Collectors.toList());

        System.out.println("Employees Sorted by Salary: " + sortedBySalary);

        // Sort by name
        List<Employee> sortedByName = employees.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());

        System.out.println("Employees Sorted by Name: " + sortedByName);

        // Jeg har færdiggjort 4.1-4.4 fra Bonus exercisen. Mangler her 4.5-4.6!

    }


}

