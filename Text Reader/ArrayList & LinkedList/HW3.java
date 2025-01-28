package edu.monmouth.hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import edu.monmouth.book.*;

public class HW3 {

	public static void main(String[] args) {
		BufferedReader bookFile = null;
		BufferedReader stringFile = null;
		
		PrintStream newIO;
		try {
			bookFile = new BufferedReader(new FileReader(HW3Constants.BOOKFILE));
			stringFile = new BufferedReader(new FileReader(HW3Constants.STRINGFILE));
			
			newIO = new PrintStream(HW3Constants.OUTPUTFILE);
			System.setErr(newIO);
			System.setOut(newIO);
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to file(s)");
			e.printStackTrace();
			System.exit(HW3Constants.FNFEXIT);
		}
		
		List<String> stringAL = new ArrayList<>();
		List<String> stringLL = new LinkedList<>();
		
		String inputString = null;
		try {
			while((inputString = stringFile.readLine()) != null) {
				stringAL.add(inputString);
				stringLL.add(inputString);
			}
		} 
		catch(IOException e) {
			System.err.println("Cannot open " + stringFile + " | " + e.getMessage());
			e.printStackTrace();
			System.exit(HW3Constants.READSTRINGEXIT);
		}
		
		List<Book> bookAL = new ArrayList<>();
		List<Book> bookLL = new LinkedList<>();

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
					String parts[] = inputBook.split(HW3Constants.DELIMITER);
					title = parts[HW3Constants.TITLEINDEX];
					bookType = BookTypes.valueOf(parts[HW3Constants.BOOKTYPEINDEX]);
					numberOfPages = Integer.parseInt(parts[HW3Constants.NUMBEROFPAGESINDEX]);
					price = Double.parseDouble(parts[HW3Constants.PRICEINDEX]);
					publicationYear = Integer.parseInt(parts[HW3Constants.PUBLICATIONYEARINDEX]);
					bookAL.add(new Book(numberOfPages, bookType, title, price, publicationYear));
					bookLL.add(new Book(numberOfPages, bookType, title, price, publicationYear));
				}
				exitFile = true;
			} 
			catch(IOException e) {
				System.err.println("Cannot open " + bookFile + " | " + e.getMessage());
				e.printStackTrace();
				System.exit(HW3Constants.READBOOKEXIT);
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
		
		System.out.println();
		System.out.println("Book ArrayList Methods");
		System.out.println("isEmpty: " + bookAL.isEmpty());
		Book bookToRemove = bookAL.get(2);
		bookAL.remove(bookToRemove);
		System.out.println("Remove " + bookToRemove + ": ");
		
		Iterator<Book> bookIterator = bookAL.iterator();
		while(bookIterator.hasNext() == true) {
			System.out.println("- " + bookIterator.next()); 
		}
		
		System.out.println("Number of Books: " + bookAL.size());
		Book bookToAdd = null;
		
		try {
			bookToAdd = new Book(208, BookTypes.HARDBACK, "The Great Gatsby", 17.00, 1925);
		} 
		catch(BookException e) {
			System.err.println("Cannot create this book");
			e.printStackTrace();
		}
		
		bookAL.add(bookToAdd);
		System.out.println("Add: " + bookToAdd);
		
		bookIterator = bookAL.iterator();
		System.out.println("Iterator:");
		while(bookIterator.hasNext() == true) {
			System.out.println("- " + bookIterator.next()); 
		}
		
		ListIterator<Book> bookListIterator = bookAL.listIterator();
		System.out.println("ListIterator:");
		while(bookListIterator.hasNext() == true) {
			System.out.println("- " + bookListIterator.next()); 
		}
		System.out.println("ListIterator in Reverse:");
		while(bookListIterator.hasPrevious() == true) {
			System.out.println("- " + bookListIterator.previous()); 
		}
		
		System.out.println();
		System.out.println("String ArrayList Methods");
		System.out.println("isEmpty: " + stringAL.isEmpty());
		String stringToRemove = stringAL.get(2);
		stringAL.remove(stringToRemove);
		System.out.println("Remove [" + stringToRemove + "]: ");
		
		Iterator<String> stringIterator = stringAL.iterator();
		while(stringIterator.hasNext() == true) {
			System.out.println("- " + stringIterator.next()); 
		}
		
		System.out.println("Number of Strings: " + stringAL.size());
		String stringToAdd = "Computer Science";
		stringAL.add(stringToAdd);
		System.out.println("Add: " + stringToAdd);
		
		stringIterator = stringAL.iterator();
		System.out.println("Iterator:");
		while(stringIterator.hasNext() == true) {
			System.out.println("- " + stringIterator.next()); 
		}
		
		ListIterator<String> stringListIterator = stringAL.listIterator();
		System.out.println("ListIterator:");
		while(stringListIterator.hasNext() == true) {
			System.out.println("- " + stringListIterator.next()); 
		}
		System.out.println("ListIterator in Reverse:");
		while(stringListIterator.hasPrevious() == true) {
			System.out.println("- " + stringListIterator.previous()); 
		}
			
		System.out.println();
		System.out.println("Book LinkedList Methods");
		bookToAdd = null;
		
		try {
			bookToAdd = new Book(374, BookTypes.HARDBACK, "The Hunger Games", 13.79, 2008);
		} 
		catch(BookException e) {
			System.err.println("Cannot create this book");
			e.printStackTrace();
		}
		
		bookLL.add(bookToAdd);
		System.out.println("Add: " + bookToAdd);	
		
		bookListIterator = bookLL.listIterator();
		System.out.println("ListIterator:");
		while(bookListIterator.hasNext() == true) {
			System.out.println("- " + bookListIterator.next()); 
		}
		System.out.println("ListIterator in Reverse:");
		while(bookListIterator.hasPrevious() == true) {
			System.out.println("- " + bookListIterator.previous()); 
		}
		
		bookIterator = bookLL.iterator();
		System.out.println("Iterator:");
		while(bookIterator.hasNext() == true) {
			System.out.println("- " + bookIterator.next()); 
		}
		
		Book bookContains = null;
		Book bookDoesNotContain = null;
		
		try {
			bookContains = new Book(426, BookTypes.SOFTBACK, "Data Structures and Algorithms", 79.99, 2019);
			bookDoesNotContain = new Book(208, BookTypes.SOFTBACK, "The Alchemist", 14.99, 2014);
		} 
		catch(BookException e) {
			System.err.println("Cannot create all books");
			e.printStackTrace();
		}
		
		System.out.println("Contains " + bookContains + ": " + bookLL.contains(bookContains));
		System.out.println("Contains " + bookDoesNotContain + ": " + bookLL.contains(bookDoesNotContain));
		System.out.println("Remove " + bookContains + ": " + bookLL.remove(bookContains));
		
		bookIterator = bookLL.iterator();
		while(bookIterator.hasNext() == true) {
			System.out.println("- " + bookIterator.next()); 
		}
		
		System.out.println("Remove " + bookDoesNotContain + ": " + bookLL.remove(bookDoesNotContain));
		
		bookIterator = bookLL.iterator();
		while(bookIterator.hasNext() == true) {
			System.out.println("- " + bookIterator.next()); 
		}
		
		System.out.println();
		System.out.println("String LinkedList Methods");
		stringToAdd = "Software Engineering";
		stringLL.add(stringToAdd);
		System.out.println("Add: " + stringToAdd);	
		
		stringListIterator = stringLL.listIterator();
		System.out.println("ListIterator:");
		while(stringListIterator.hasNext() == true) {
			System.out.println("- " + stringListIterator.next()); 
		}
		System.out.println("ListIterator in Reverse:");
		while(stringListIterator.hasPrevious() == true) {
			System.out.println("- " + stringListIterator.previous()); 
		}
		
		stringIterator = stringLL.iterator();
		System.out.println("Iterator:");
		while(stringIterator.hasNext() == true) {
			System.out.println("- " + stringIterator.next()); 
		}
		
		String stringContains = "Monmouth University";
		String stringDoesNotContain = "Artificial Intelligence";
		System.out.println("Contains [" + stringContains + "]: " + stringLL.contains(stringContains));
		System.out.println("Contains [" + stringDoesNotContain + "]: " + stringLL.contains(stringDoesNotContain));
		System.out.println("Remove [" + stringContains + "]: " + stringLL.remove(stringContains));
		
		stringIterator = stringLL.iterator();
		while(stringIterator.hasNext() == true) {
			System.out.println("- " + stringIterator.next()); 
		}
		
		System.out.println("Remove [" + stringDoesNotContain + "]: " + stringLL.remove(stringDoesNotContain));
		
		stringIterator = stringLL.iterator();
		while(stringIterator.hasNext() == true) {
			System.out.println("- " + stringIterator.next()); 
		}
		
		System.exit(HW3Constants.OUTPUTEXIT);
		
	}

}
