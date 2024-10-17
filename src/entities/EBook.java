package entities;

import constants.Enum.Genre;
import service.Book;

public class EBook extends Book {
    public EBook(String title, String author, Genre genre, double price) {
        super(title, author, genre, price);
    }

    public void displayBookInfo() {
        System.out.println(("E-entity.Book: " + getTitle() + " by " + getAuthor()));
    }
}