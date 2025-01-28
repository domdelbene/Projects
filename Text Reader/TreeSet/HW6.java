package edu.monmouth.hw6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import edu.monmouth.book.*;

public class HW6 {

	public static void main(String[] args) {
		// make sure there is 1 and only 1 cmd arg
		if(args.length != HW6Constants.NUMBEROFARGUMENTS) {
			System.err.println("Enter name of props file");
			System.exit(HW6Constants.WRONGARGUMENTS);
		}
		
		// 1 cmd arg is name of property file
		String propsFileName = args[HW6Constants.PROPSINDEX];
		
		// create Properties object
		Properties properties = new Properties();
		
		try {
			properties.load(new BufferedReader(new FileReader(propsFileName)));
		}
		catch(IOException e) {
			System.err.println("Cannot load " + propsFileName + " | " + e.getMessage());
			e.printStackTrace();
			System.exit(HW6Constants.PROPSEXIT);
		}
		
		// load value of log_file_name
		String logFileName = properties.getProperty(HW6Constants.LOGFILENAME);
		
		/*PrintStream newIO;
		try {
			newIO = new PrintStream(logFileName);
			System.setErr(newIO);
			System.setOut(newIO);
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to " + logFileName);
			e.printStackTrace();
			System.exit(HW6Constants.FNFEXIT);
		}*/
		
		// load value of book_file_name
		String bookFileName = properties.getProperty(HW6Constants.BOOKFILENAME);
		
		// load value of delimiter
		String delimiter = properties.getProperty(HW6Constants.BOOKDELIMITER);
		
		// create a TreeSet to store Books
		Set<Book> treeSet = new TreeSet<>();
		
		// read book data file, create Book (if possible), populate TreeSet
		BufferedReader bookFile = null;
		
		try {
			bookFile = new BufferedReader(new FileReader(bookFileName));
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to " + bookFileName);
			e.printStackTrace();
			System.exit(HW6Constants.FNFEXIT);
		}
		
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
					String parts[] = inputBook.split(delimiter);
					title = parts[HW6Constants.TITLEINDEX];
					System.out.println(title);
					bookType = BookTypes.valueOf(parts[HW6Constants.BOOKTYPEINDEX]);
					numberOfPages = Integer.parseInt(parts[HW6Constants.NUMBEROFPAGESINDEX]);
					price = Double.parseDouble(parts[HW6Constants.PRICEINDEX]);
					publicationYear = Integer.parseInt(parts[HW6Constants.PUBLICATIONYEARINDEX]);
					Book book = new Book(numberOfPages, bookType, title, price, publicationYear);
					treeSet.add(book);
				}
				exitFile = true;
			} 
			catch(IOException e) {
				System.err.println("Cannot open " + bookFile + " | " + e.getMessage());
				e.printStackTrace();
				System.exit(HW6Constants.READBOOKEXIT);
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
		
		// iterate and print out each Book in the TreeSet
		System.out.println("TreeSet:");
		Iterator<Book> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// using BookPrice class create a TreeSet (this will use BookPrice to order)
		Set<Book> treePrice = new TreeSet<Book>(new BookPrice());
		
		// populate TreeSet
		for(Book book : treeSet) {
			treePrice.add(book);
		}
		
		// iterate and print out each Book in the TreeSet demonstrating order by price alone
		System.out.println("\nTreeSet from Lowest to Highest Price:");
		iterator = treePrice.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.exit(HW6Constants.OUTPUTEXIT);
	}

}
