package edu.monmouth.book;

public class BookTest {

	public static void main(String[] args)  {
		Book b1 = null;
		Book b2 = null;
		Book b3 = null;
		Book b4 = null;
		
		try {
			b1 = new Book(208, BookTypes.HARDBACK, "The Great Gatsby", 17.00, 1925);
			b2 = new Book(374, BookTypes.HARDBACK, "The Hunger Games", 13.79, 2008);
			b3 = new Book(208, BookTypes.SOFTBACK, "The Alchemist", 14.99, 2014);
			b4 = new Book(720, BookTypes.ELECTRONIC, "Game of Thrones", 8.99, 1996);
		}
		catch(BookException e) {
			System.err.println("Cannot create all books");
			e.printStackTrace();
		}
		try {
			b1.setNumberOfPages(0);
			System.out.println(b1.getNumberOfPages());
		}
		catch(BookException e) {
			System.out.println("Cannot call mutator method | " + e.getMessage());
			e.printStackTrace();
		}
		try {
			b1.setTitle("");
			System.out.println(b1.getTitle());
		}
		catch(BookException e) {
			System.out.println("Cannot call mutator method | " + e.getMessage());
			e.printStackTrace();
		}
		b1.setBookType(BookTypes.HARDBACK);
		System.out.println(b1.getBookType());
		try {
			b1.setPrice(-1);
			System.out.println(b1.getPrice());
		}
		catch(BookException e) {
			System.out.println("Cannot call mutator method | " + e.getMessage());
			e.printStackTrace();
		}
		try {
			b1.setPublicationYear(2027);
			System.out.println(b1.getPublicationYear());
		}
		catch(BookException e) {
			System.out.println("Cannot call mutator method | " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b3.toString());
		System.out.println(b4.toString());
	}

}
