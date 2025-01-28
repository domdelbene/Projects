package edu.monmouth.book;

import java.time.LocalDate;

public class Book {

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
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		if(!(otherObject instanceof Book)) {
			return false;
		}
		if(this == otherObject) {
			return true;
		}
		Book otherBook = (Book)otherObject;
		return otherBook.title.equals(title) && otherBook.numberOfPages == numberOfPages && otherBook.bookType == bookType;
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("Book [Title: " + title + ", Number Of Pages: " + numberOfPages + ", Book Type: " + bookType + ", Price: " + price + ", Publication Year: " + publicationYear + "]");
		return build.toString();
	}
}
