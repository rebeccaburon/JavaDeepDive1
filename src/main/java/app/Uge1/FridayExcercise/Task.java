package app.Uge1.FridayExcercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@ToString
@AllArgsConstructor

class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    }


