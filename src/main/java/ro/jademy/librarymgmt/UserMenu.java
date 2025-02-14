package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {

    public static void userMenu() throws FileNotFoundException {

//Creating arraylist of books from .CSV file
        Scanner scanner = new Scanner(System.in);
        boolean menuExit = false;
        File fileName = new File("onlineBooks_database.csv");
        ArrayList<Book> bookList = LibraryFileIO.readingBook(fileName);

        while (!menuExit) {

            LibraryMenu.printUserMenu();
            System.out.print("Please choose an option (1-6): ");

            int option = scanner.nextInt();

            switch (option) {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(bookList);
                    ListBookTable.printTableBooks(148);

                    break;

                //search for a book
                case 2:
                    System.out.print("Search for (title/author/genre/publisher/ISBN: ");
                    String filter = scanner.next();

                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(Library.searchBooks(filter, bookList));
                    ListBookTable.printTableBooks(148);

                    break;

                //wishlist
                case 3:
                    System.out.println("wishlist procedure");
                    break;

                //book description
                case 4:

                    System.out.println("Book description procedure");

                    break;

                //user details
                case 5:
                    System.out.println("user details procedure");

                    break;

                //exit
                case 6:
                     menuExit=true;
                    //System.exit(0);
                    break;


                default:
                    System.out.println("\nPlease choose an option (1-6): ");
                    option = scanner.nextInt();


            }
        }


    }

}

