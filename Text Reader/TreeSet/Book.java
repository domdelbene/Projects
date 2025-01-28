package edu.monmouth.book;

import java.time.LocalDate;

public class Book implements Comparable<Book> {

	private double price;
	private BookTypes bookType;
	private int numberOfPages;
	private String title;
	private int publicationYear;
	
	public Book(int numberOfPages, BookTypes bookType, String title, double price, int publicationYear) throws BookException {
		setNumberOfPages(numberOfPages);
		setTitle(title);
		setBookType(bookType);
		setPrice(price);
		setPublicationYear(publicationYear);
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) throws BookException {
		if(numberOfPages < BookConstants.NUMBEROFPAGESPRECONDITION) {
			throw new BookException("Number of pages cannot be less than 1");
		}
		this.numberOfPages = numberOfPages;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws BookException {
		if(title == null || title.length() == BookConstants.TITLEPRECONDITION) {
			throw new BookException("Title cannot be null and cannot have a length of 0");
		}
		this.title = title;
	}
	public BookTypes getBookType() {
		return bookType;
	}
	public void setBookType(BookTypes bookType) {
		this.bookType = bookType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) throws BookException {
		if(price <= BookConstants.PRICEPRECONDITION) {
			throw new BookException("Price cannot be negative");
		}
		this.price = price;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) throws BookException {
		LocalDate l = LocalDate.now();
		int year = l.getYear();
		if(publicationYear <= 0 || publicationYear > year + BookConstants.PUBLICATIONYEARPRECONDITION) {
			throw new BookException("Publication Year cannot be negative or cannot be more than 2 years in the future");
		}
		this.publicationYear = publicationYear;
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("In Book equals...");
		
		if(o == null) {
			return false;
		}
		if(!(o instanceof Book)) {
			return false;
		}
		if(o == this) {
			return true;
		}
		Book otherBook = (Book)o;
		return otherBook.numberOfPages == numberOfPages && otherBook.bookType.equals(bookType) && otherBook.title.equals(title);
	}
	
	@Override
	public int compareTo(Book otherBook) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1; 
		
		if(this == otherBook) {
			return EQUAL;
		}
		System.out.println("In Book's compareTo");
		if(this.numberOfPages < otherBook.numberOfPages) {
			return BEFORE;
		}
		if(this.numberOfPages > otherBook.numberOfPages) {
			return AFTER;
		}
		// numberOfPages are = order using bookType & title
		if(this.bookType.compareTo(otherBook.bookType) == 0) {
			// numberOfPages & bookType are = order using title
			return this.title.compareTo(otherBook.title);
		}
		else {
			return (this.bookType.compareTo(otherBook.bookType));
		}
	}
	
	@Override
	public int hashCode() {
		System.out.println("In Book hashCode...");
		Integer pages = numberOfPages;
		return title.hashCode() + pages.hashCode() + bookType.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("Book [Title: " + title + ", Number Of Pages: " + numberOfPages + ", Book Type: " + bookType + ", Price: " + price + ", Publication Year: " + publicationYear + "]");
		return build.toString();
	}
}
