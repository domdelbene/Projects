package edu.monmouth.hw2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import edu.monmouth.book.*;

public class HW2 {

	public static void main(String[] args) {
		if(args.length != HW2Constants.NUMBEROFARGUMENTS) {
			System.out.println("Provide a command line argument");
			System.exit(0);
		}
		PrintStream newIO;
		try {
			newIO = new PrintStream(HW2Constants.OUTPUTFILE);
			System.setErr(newIO);
			System.setOut(newIO);
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to " + HW2Constants.OUTPUTFILE);
			e.printStackTrace();
			System.exit(HW2Constants.REDIRECTFAILED);
		}
		
		ListNode list = new ListNode();
		
		System.out.println("First: " + list.first());
		System.out.println("Removed first: " + list.removeFirst());
		System.out.println("Last: " + list.last());
		System.out.println("Entire list: \n" + list);
		
		Book book1 = null;
		Book book2 = null;
		Book book3 = null;
		Book book4 = null;
		Book badBook = null;
		
		try{
			book1 = new Book(88, BookTypes.HARDBACK, "To Kill a Mockingbird", 25.99, 1942);
			book2 = new Book(129, BookTypes.SOFTBACK, "For Whom the Bell Tolls", 15.25, 1920);
			book3 = new Book(239, BookTypes.HARDBACK, "Undaunted Courage", 32.50, 2002);
			book4 = new Book(12, BookTypes.HARDBACK, "Goodnight Moon", 19.00, 1961);
			badBook = new Book(-9, BookTypes.HARDBACK, "Goodnight Moon", 19.00, 1961);
		} catch(BookException e) {
			System.err.println("Cannot create all books");
			e.printStackTrace();
			//System.exit(HW2Constants.BOOKFAILURE);
		}
		
		list.insert(book1);
		list.insert(book2);
		list.insert(book3);
		
		System.out.println("After inserting 3 books: \n" + list);
		
		list.insertEnd(book4);
		 
		System.out.println("After adding fourth book: \n" + list);
		
		System.out.println("First: " + list.first());
		
		System.out.println("Last: " + list.last());

		System.out.println("Removed first: " + list.removeFirst());
		System.out.println("Entire list: \n" + list);
	}
	
}
