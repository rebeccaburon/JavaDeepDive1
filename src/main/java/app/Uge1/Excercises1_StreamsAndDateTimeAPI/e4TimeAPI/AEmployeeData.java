package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e4TimeAPI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AEmployeeData {
    public static List<AEmployee> getEmployees() {
        return Arrays.asList(
                new AEmployee("Alice", 30, "HR", 50000, LocalDate.parse("1993-08-18")),
                new AEmployee("Hans", 45, "Finance", 75000, LocalDate.parse("1978-05-12")),
                new AEmployee("Mette", 40, "IT", 80000, LocalDate.parse("1983-03-23")),
                new AEmployee("Jesper", 35, "IT", 70000, LocalDate.parse("1988-12-04")),
                new AEmployee("Anna", 50, "Finance", 90000, LocalDate.parse("1973-02-15")),
                new AEmployee("Ib", 25, "HR", 45000, LocalDate.parse("1998-10-30")),
                new AEmployee("Vanessa", 29, "Finance", 55000, LocalDate.parse("1994-07-21"))
        );
    }
}
