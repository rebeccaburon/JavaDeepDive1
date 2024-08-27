package app.Uge1.FridayExcercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList <T extends Task> implements Iterable{
    private ArrayList<T> task = new ArrayList<>();

    //Add tasks to the list.
    public void addTask(T task) {
        this.task.add(task);
    }

    //Filter tasks based on a keyword in the title or description.
    public List<T> filterTasks(String keyword){
        return task.stream()
                .filter(task -> task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }

//    Sort tasks by due date.
    public List<T> sortTaskByDueDate (){
        return task.stream()
                .sorted((t1,t2) -> t1.getDueDate().compareTo(t2.getDueDate()))
                .collect(Collectors.toList());
    }
//    Get tasks that are due today.
    public List <T> getTaskDueToday(){
        LocalDate today = LocalDate.now();
        return task.stream()
        //Forsøg på at tjekke om der er en task i dag.
                .filter(task -> task.getDueDate() !=null ? task.getDueDate().isEqual(today) : false)
                .collect(Collectors.toList());
    }

//    Get tasks that are overdue
    public List <T> getOverdueTask(){
        LocalDate today = LocalDate.now();
        return task.stream()
                .filter(task -> task.getDueDate().isBefore(today))
                .collect(Collectors.toList());
    }

//    Print the list of tasks.
public void printTask(List<T> taskList){
        taskList.forEach(System.out::println);
}
//allow repetition over the tasks
    @Override
    public Iterator<T> iterator() {
        return task.iterator();
    }


}
