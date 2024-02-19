package library;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sampath Gunnam
 */
public class Library {
    // Defining Address variable to store the address of the Library.
String Address;

// declaring and initializing open_time and close_time variables and setting them as final 

    private static final String OPEN_TIME = "9:00am";
    private static final String CLOSE_TIME = "4:30pm";
    
    List<Book> listOfBooks = new ArrayList<>();

    public Library(String LibraryAddress) {
        this.Address = LibraryAddress;
    }

    public void addBook(Book BookTitle) {
        this.listOfBooks.add(BookTitle);
    }

    //  To let the user know the timings of the library
    public static void printOpeningHours() {
        // Printing the opening and closing hours of the library
        System.out.print("Libraries are open daily from " + OPEN_TIME + " to " + CLOSE_TIME + ".");
    }

    // To let the user know the address of the library
    public void printAddress() {
        // Printing the address of the library
        System.out.println(this.Address);
    }

    // Borrowing the user selected book from the library
    public void borrowBook(String BookTitle) {
        // Checking the book availability by accessing the book class
        for(int i = 0; i < this.listOfBooks.size(); i++)
        {
            if (this.listOfBooks.get(i).getTitle().equals(BookTitle)) {
                // if the book is borrowed already then let user know
                if (!this.listOfBooks.get(i).isBorrowed()) {
                    // If the book is avilable the let the user know
                    System.out.println("You successfully borrowed " + BookTitle);

                    // Marking the given book as borrowed
                    this.listOfBooks.get(i).borrowed();
                    return;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }
    
    // Getting the list of available books in the library
    public void printAvailableBooks(){
        // Printing the list of books available in the library
        if(!this.listOfBooks.isEmpty()){
            for(int i = 0; i < this.listOfBooks.size(); i++)
            {
                if(!this.listOfBooks.get(i).isBorrowed())
                    System.out.println(this.listOfBooks.get(i).getTitle());
            }
        }
        else
            System.out.println("No book in catalog");
    }
    
    // Returning the book and marking it as borrowed
    public void returnBook(String BookTitle){
        
        // checking the book ewas atleast registered in the library
        for (int i = 0; i < this.listOfBooks.size(); i++) {
            if (this.listOfBooks.get(i).getTitle().equals(BookTitle)) {
                // marking the book as returned by accessing book class object
                this.listOfBooks.get(i).returned();
                System.out.println("You successfully returned " + BookTitle);
            }
        }
    }

    public static void main(String[] args) {
        // creating tow objects for library class representing two different locations
        Library firstSection = new Library("300 College Park Dr.");
        Library secondSection = new Library("Ohio Link.");

        // Adding four different books to the first library
        firstSection.addBook(new Book("Java How To Program (Early Objects)): "));
        firstSection.addBook(new Book("Rise of the Robots"));
        firstSection.addBook(new Book("Code Complete"));
        firstSection.addBook(new Book("The Pragmatic Programmer"));

        // Print opening hours and the addresses 
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstSection.printAddress();
        secondSection.printAddress();
        System.out.println();

        // Try to borrow The Pragmatic Programmer from both sections 
        System.out.println("Borrowing The Pragmatic Programmer:");
        firstSection.borrowBook("The Pragmatic Programmer");
        firstSection.borrowBook("The Pragmatic Programmer");
        secondSection.borrowBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of all available books from both sections 
        System.out.println("Books available in the first Section:");
        firstSection.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second Section:");
        secondSection.printAvailableBooks();
        System.out.println();

        // Return The Pragmatic Programmer to the first section 
        System.out.println("Returning The Pragmatic Programmer:");
        firstSection.returnBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of available from the first Section 
        System.out.println("Books available in the first section:");
        firstSection.printAvailableBooks();
    }
}
