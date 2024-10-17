package service;

import constants.Enum.Genre;
import constants.Enum.Status;

public abstract class Book {
    private final int id;
    private static int idCounter = 1;
    private final String title;
    private final String author;
    private final Genre genre;
    private final double price;
    private Status status;

    public Book(String title, String author, Genre genre, double price) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.status = Status.AVAILABLE;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public abstract void displayBookInfo();
}
