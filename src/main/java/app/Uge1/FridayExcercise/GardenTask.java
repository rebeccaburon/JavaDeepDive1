package app.Uge1.FridayExcercise;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter


public class GardenTask extends Task {
    private final String gardenLocation;

    public GardenTask(String title, String description, LocalDate dueDate, String gardenLocation) {
        super(title, description, dueDate);
        this.gardenLocation = gardenLocation;
    }
}
