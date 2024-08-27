package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e1StreamsAPIBasics;

public class Book {
    private String title;
    private String author;
    private String publication;
    private int year;
    private int pages;
    private double rating;

    public Book(String title, String author, String publication, int year, double rating, int pages) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.year = year;
        this.rating = rating;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book title = " + title +
                ", Author = " + author + '\'' +
                ", Publication = " + publication + '\'' +
                ", Year = " + year +
                ", Pages = " + pages +
                ", Rating = " + rating;
    }
}
