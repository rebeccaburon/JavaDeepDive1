package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e1StreamsAPIBasics;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of books
        List<Book> bookList = getBooks();

        // Calculate the average rating of all books
        OptionalDouble averageRating = bookList.stream()
                .mapToDouble(Book::getRating)
                .average();
       // averageRating.ifPresent(System.out::println);


        // Filter and display books published after a specific year

        int publishYear = 1975;
       List<Book> filteredBooks = bookList.stream()
                .filter(book -> book.getYear()>publishYear)
                .collect(Collectors.toList());
       // filteredBooks.forEach(book -> System.out.println(book.getTitle()));

        // Sort books by rating in descending order
        List<Book> sortedRatings = bookList.stream()
                .sorted(Comparator.comparing(Book ::getRating).reversed())
                .collect(Collectors.toList());
               // sortedRatings.forEach(System.out::println);

        // Find and display the title of the highest-rated book
        bookList.stream()
                .max(Comparator.comparing(Book::getRating))
                .ifPresent(book -> System.out.println("Title for higest-rated book = " + book.getTitle() +"\nThe rating is = " + book.getRating()));

        // Group books by author and calculate average rating for each author
        Map<String, Double> averageRatingByAuthor = bookList.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.averagingDouble(Book::getRating)
                ));
        System.out.println("Average rating by author:");
        averageRatingByAuthor.forEach((author, avgRating) ->
                System.out.println(author + " : " + avgRating));


        // Calculate the total number of pages for all books
        int totalPages = bookList.stream()
                .mapToInt(Book::getPages)
                .sum();
        System.out.println("Total number of pages: " + totalPages);
    }

    public static List<Book> getBooks() {
        return List.of(
                new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, 4.67, 358),
                new Book("1864", "George Orwell", "Secker & Warburg", 1949, 8.67, 432),
                new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", 1994, 2.67, 587),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1975, 6.98, 650),
                new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1905, 5.43, 235),
                new Book("Moby Dick", "Herman Melville", "Harper & Brothers", 2000, 9.22, 410),
                new Book("War and Peace", "Leo Tolstoy", "The Russian Messenger", 1965, 7.87, 570)
        );
    }
}
