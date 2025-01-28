package edu.monmouth.hw6;

import java.util.Comparator;

import edu.monmouth.book.*;

public class BookPrice implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1; 
		
		if(book1.getPrice() < book2.getPrice() ) {
			return BEFORE;
		}
		if(book1.getPrice() > book2.getPrice() ) {
			return AFTER;
		}
		return EQUAL;
	}
}
