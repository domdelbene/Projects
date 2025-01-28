package edu.monmouth.hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.monmouth.book.*;

public class BookHW4 {
	public static void main(String args[]) {
		// validate 2 command line arguments are passed in
		// first argument is the name of the data file
		// second argument is the name of the file to which stdout & stderr are redirected
		BufferedReader bookFile = null;
		PrintStream newIO;
		
		if(args.length != HW4Constants.NUMBEROFBOOKARGUMENTS) {
			System.out.println("Provide 2 command line arguments");
			System.exit(HW4Constants.WRONGARGUMENTS);
		}
		// redirect stdout & stderr to specified file
		try {
			bookFile = new BufferedReader(new FileReader(args[HW4Constants.BOOKFILEINDEX]));
			
			newIO = new PrintStream(args[HW4Constants.OUTPUTFILEINDEX]);
			System.setErr(newIO);
			System.setOut(newIO);
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to file(s)");
			e.printStackTrace();
			System.exit(HW4Constants.FNFEXIT);
		}
		// create a HashSet that contains Book objects (name it bookSet)
		Set<Book> bookSet = new HashSet<>();
				
		// open and read the data file, creating Book objects (if valid)
		// for each Book object created, add the Book object to the HashSet.
		String inputBook = null;
		String title;
		BookTypes bookType = null;
		int numberOfPages;
		double price; 
		int publicationYear;
		boolean exitFile = false;
		
		while(!exitFile) {
			try {
				while((inputBook = bookFile.readLine()) != null) {
					String parts[] = inputBook.split(HW4Constants.DELIMITER);
					title = parts[HW4Constants.TITLEINDEX];
					bookType = BookTypes.valueOf(parts[HW4Constants.BOOKTYPEINDEX]);
					numberOfPages = Integer.parseInt(parts[HW4Constants.NUMBEROFPAGESINDEX]);
					price = Double.parseDouble(parts[HW4Constants.PRICEINDEX]);
					publicationYear = Integer.parseInt(parts[HW4Constants.PUBLICATIONYEARINDEX]);
					Book book = new Book(numberOfPages, bookType, title, price, publicationYear);
					if(bookSet.add(book) == true) {
						System.out.println("Successfully added book to HashSet");
					} 
					else {
						System.out.println("Book was not added to HashSet");
					}
				}
				exitFile = true;
			} 
			catch(IOException e) {
				System.err.println("Cannot open " + bookFile + " | " + e.getMessage());
				e.printStackTrace();
				System.exit(HW4Constants.READBOOKEXIT);
			}
			catch(BookException e) {
				System.err.println("Cannot make Book object | " + e.getMessage());
				e.printStackTrace();
			}
			catch(NumberFormatException e) {
				System.err.println("Cannot convert String to a numeric type | " + e.getMessage());
				e.printStackTrace();
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.err.println("Array out of bounds | " + e.getMessage());
				e.printStackTrace();
			}
			catch(IllegalArgumentException e) {
				System.err.println("Illegal argument | " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		// after data file is read and valid Book objects added to Hashset iterate over HashSet 
		// printing each Book object 
		Iterator<Book> iterator = bookSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
			
		// determine if the following 2 books are in the HashSet
		Book bookToFind = null;
		try {
			bookToFind = new Book(829, BookTypes.HARDBACK, "The Soloman Curse", 23.95, 2003);
			if(bookSet.contains(bookToFind) == true) {
				System.out.println(bookToFind + "\nExists in bookSet");
			} else {
				System.out.println(bookToFind + "\nDoes not exist in bookSet");
			}
			bookToFind = new Book(629, BookTypes.HARDBACK, "The BigBang Theory", 87.00, 2010);
			if(bookSet.contains(bookToFind) == true) {
				System.out.println(bookToFind + "\nExists in bookSet");
			} else {
				System.out.println(bookToFind + "\nDoes not exist in bookSet");
			}
		} catch (BookException e) {
			System.err.println("Cannot create a Book object from these values:\n" + bookToFind + e.getMessage());
		}
		System.exit(HW4Constants.OUTPUTEXIT);
	}
}

