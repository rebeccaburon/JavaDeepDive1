package app.Uge1.FridayExcercise;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
TaskList<Task> taskList = new TaskList<>();

//Creating task

        Task task1 = new Task("Task 1", "Clean Your room", LocalDate.now().plusDays(7));
        Task task2 = new Task("Task 2", "Do the laundry", LocalDate.now().plusDays(0));
        Task task3 = new Task("Task 3", "Go get apples", LocalDate.now().minusDays(4));
        GardenTask gardenTask1 = new GardenTask("Garden Task 1", "Plant flowers", LocalDate.now().plusDays(4), "Backyard");
        GardenTask gardenTask2 = new GardenTask("Garden Task 2", "Get fertilizer for", LocalDate.now().plusDays(8), "Frontyard");
        GardenTask gardenTask3 = new GardenTask("Garden Task 3", "Get stones for water stream", LocalDate.now().plusDays(0), "Backyard");

        //adding all task to the list
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(gardenTask1);
        taskList.addTask(gardenTask2);
        taskList.addTask(gardenTask3);

        //Filtering task by the keyword
        List<Task> filteredTask = taskList.filterTasks("Task");
      System.out.println("\n Her is the filtered tasks:");
        taskList.printTask(filteredTask);

        // Sorting tasks by due date
        List<Task> sortedTasks = taskList.sortTaskByDueDate();
        System.out.println("\nHere is the sorted Tasks by Due Date:");
        taskList.printTask(sortedTasks);

        // Getting tasks due today
        List<Task> tasksDueToday = taskList.getTaskDueToday();
        System.out.println("\nHere is the Tasks Due Today!!:");
        taskList.printTask(tasksDueToday);

        // Getting overdue tasks
        List<Task> overdueTasks = taskList.getOverdueTask();
        if (overdueTasks.size() > 0) {
            System.out.println("\nHere is the Overdue Tasks!! Get to work!:");
            taskList.printTask(overdueTasks);
        } else {
            System.out.println("\nNo task are overdue!\nGo get a beer!");
        }

    }
}
