import constants.Enum.Genre;
import constants.Enum.MembershipType;
import entities.EBook;
import entities.PrintedBook;
import entities.User;
import service.Book;
import service.Library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean exit = false;

        while (!exit) {
            System.out.print("------------------------------\n");
            System.out.println("service.Library Management Menu:");
            System.out.println("1. Add entity.Book");
            System.out.println("2. Borrow entity.Book");
            System.out.println("3. Return entity.Book");
            System.out.println("4. List Available Books");
            System.out.println("5. List Borrowed Books");
            System.out.println("6. Register User");
            System.out.println("7. User Details");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.print("------------------------------\n");

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    StringBuffer titleBuffer = new StringBuffer(title);
                    String titleWithBuffer = titleBuffer.toString();
                    System.out.print("Enter book Author: ");
                    String Author = scanner.nextLine();
                    System.out.print("Enter book Genre (SCI_FI, NOVEL, MYSTERY): ");
                    String stringGenre = scanner.nextLine();
                    Genre genre;
                    if (stringGenre.equalsIgnoreCase("SCI_FI") || stringGenre.equalsIgnoreCase("NOVEL") ||stringGenre.equalsIgnoreCase("MYSTERY")) {
                        genre = Genre.valueOf(stringGenre.toUpperCase());
                    } else {
                        System.out.println("Invalid Genre type.");
                        break;
                    }
                    System.out.print("Enter book Price: ");
                    String stringPrice =scanner.nextLine();
                    double price;
                    if (isDouble(stringPrice)) {
                        price = Double.parseDouble(stringPrice);
                    }
                    else {
                        System.out.println("Invalid Price");
                        break;
                    }
                    System.out.print("Enter book type (entity.PrintedBook or entity.EBook): ");
                    String BType = scanner.nextLine();
                    if (BType.equalsIgnoreCase("entity.PrintedBook")) {
                        library.addBook(new PrintedBook(titleWithBuffer, Author, genre, price));
                        System.out.println("entity.Book added.");
                    }
                    else if (BType.equalsIgnoreCase("entity.EBook")) {
                        library.addBook(new EBook(titleWithBuffer, Author, genre, price));
                        System.out.println("entity.Book added.");
                    } else {
                        System.out.println("Invalid book type. Please enter either entity.PrintedBook or entity.EBook.");
                        break;
                    }
                    break;
                case 2:
                    System.out.print("Enter a UserId: ");
                    int borrowingUser = scanner.nextInt();
                    scanner.nextLine();
                    User user = library.findUserByName(borrowingUser);
                    if(user == null) {
                        break;
                    }
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book book = library.findBookByTitle(borrowTitle);
                    if(book == null) {
                        break;
                    }
                    library.issueBook(user, book);
                    break;
                case 3:
                    System.out.print("Enter a UserId: ");
                    int returnUser = scanner.nextInt();
                    User reuser = library.findUserByName(returnUser);
                    scanner.nextLine();
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book book1 = library.findBookByTitle(returnTitle);
                    library.returnBook(reuser, book1);
                    break;
                case 4:
                    library.listAvailableBook();
                    break;
                case 5:
                    library.listBorrowedBook();
                    break;
                case 6:
                    System.out.print("Enter User Name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter Membership Type(Regular, Premium): ");
                    String Type = scanner.nextLine();
                    MembershipType type;
                    if (Type.equals("Regular") || Type.equals("Premium")) {
                        type = MembershipType.valueOf(Type.toUpperCase());
                    } else {
                        System.out.println("Invalid User type.");
                        break;
                    }
                    library.adduser(new User(Name, type));
                    break;
                case 7:
                    library.listAllUser();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    private static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
