package app.Uge1.Excercises2_FunctionalProgramming.e4Generics;

public interface DataStorage<T> {
    String store(T data); // return a unique ID for the stored data or the filename
    T retrieve(String source); // retrieve data from the specified source (like a file or database table or ID)
}