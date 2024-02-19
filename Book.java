package library;

/**
 *
 * @author Sampath Gunnam
 */
public class Book {

	String title; 
	boolean borrowed; 


	// Creates a new Book
	public Book(String bookTitle) {
            // Assigning book title to title attribute passed by user
            this.title = bookTitle;
	}

	// Marks the book as rented
	public void borrowed() {
		// Making borrowed as true as the book is borrowed
                this.borrowed = true;
	}

	// Marks the book as not rented
	public void returned() {
		// Making borrowed as false as the book is returned
                this.borrowed = false;
	}

	// Returns true if the book is rented, false otherwise
	public boolean isBorrowed() {
            // Checking the condition that the book is returned or borrowed
            return this.borrowed;
	}

	// Returns the title of the book
	public String getTitle() {
		// getting the title of the book
                return this.title;
	} 

	public static void main(String[] arguments) {
	// Small test of the Book class
	Book example = new Book("Java How To Program (Early Objects))"); 
	System.out.println("Title (should be Java How To Program (Early Objects))) " + example.getTitle()); 
	System.out.println("Borrowed? (should be false): " + example.isBorrowed()); 
	example.borrowed(); 
	System.out.println("Borrowed? (should be true): " + example.isBorrowed()); 
	example.returned(); 
	System.out.println("Borrowed? (should be false): " + example.isBorrowed()); 
	}
}
