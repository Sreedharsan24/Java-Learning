package service;

import constants.Enum.Status;
import entities.User;

import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> books;
    private final ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void adduser(User user) {
        users.add(user);
    }

    public void listAllUser() {
        System.out.println("Available Users:");
        for (User user:users) {
            System.out.println("User: " + user.getId() + " : " + user.getName() + ", Membership: " + user.getMembershipType());
            user.listBorrowedBooks();
        }
    }

    public User findUserByName(int name) {
        for (User user : users) {
            if (user.getId() == name) {
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not available or does not exist.");
        return null;
    }

    public void issueBook(User user, Book book) {
        if (user.getBooksBorrowed().size() <= 2) {
            if (book.getStatus() == Status.AVAILABLE) {
                book.setStatus(Status.BORROWED);
                user.borrowBook(book);
                System.out.println(user.getName() + " borrowed " + book.getTitle());
            } else {
                System.out.println("The book is not available.");
            }
        } else {
            System.out.println(user.getName() + " has already borrowed 3 books. Cannot borrow more.");
        }
    }

    public void returnBook(User user, Book book) {
        if (user.getBooksBorrowed().contains(book)) {
            book.setStatus(Status.AVAILABLE);
            user.returnBook(book);
            System.out.println(user.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("The book is not available.");
        }
    }

    public void listAvailableBook() {
        System.out.println("Available Books:");
        for (Book book: books) {
            if(book.getStatus() == Status.AVAILABLE) {
                book.displayBookInfo();
            }
        }
    }

    public void listBorrowedBook() {
        System.out.println("Borrowed Books:");
        for (Book book: books) {
            if(book.getStatus() == Status.BORROWED) {
                book.displayBookInfo();
            }
        }
    }

}
