package entities;

import constants.Enum.Genre;
import service.Book;

public class PrintedBook extends Book {
    public PrintedBook(String title, String author, Genre genre, double price) {
        super(title, author, genre, price);
    }

    public void displayBookInfo() {
        System.out.println(("PrintedBook: " + getTitle() + " by " + getAuthor()));
    }
}