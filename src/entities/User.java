package entities;

import constants.Enum.MembershipType;
import service.Book;

import java.util.ArrayList;

public class User extends Person{
    private final MembershipType membershipType;
    private final ArrayList<Book> booksBorrowed;

    public User(String Name, MembershipType Type) {
        super(Name);
        this.membershipType = Type;
        this.booksBorrowed = new ArrayList<>();
    }
    public MembershipType getMembershipType() { return membershipType; }

    public void listBorrowedBooks() {
        System.out.println("Books borrowed by " + getName() + ":");
        if (booksBorrowed.isEmpty()) {
            System.out.println("No Books Borrowed");
            System.out.println("--");
        } else {
            for (Book book:booksBorrowed) {
                System.out.println(book.getTitle());
            }
        }
    }

    public ArrayList<Book> getBooksBorrowed() { return booksBorrowed; }

    public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
    }
}
