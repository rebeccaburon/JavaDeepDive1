package app.Uge1.Excercises2_FunctionalProgramming.e4Generics;

public class DataStorageApp {
    public static void main(String[] args) {
        //Gemme i MemoryStorage - a List
        DataStorage<String> memoryStorage = new MemoryStorage<>();
      String key= memoryStorage.store("Hello, world!");
        String retrievedString = memoryStorage.retrieve(key);
        System.out.println("Vi har hentet:" + retrievedString);

        // Gemme i fil
        // To observe the contents of the file where the Employee object is stored (in the EmployeeStorage file),
        // you need to keep in mind that the file contains serialized data, which is in binary format.
        // This means you won't be able to view the contents directly as human-readable text.

        DataStorage<Employee> fileStorage = new FileStorage<>();
        String filename = fileStorage.store(new Employee("John", 30));
        Employee retrievedInt = fileStorage.retrieve(filename);
        System.out.println("Vi har hentet:" + retrievedInt);

    }
}