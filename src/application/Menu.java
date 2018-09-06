package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import entity.Books;


public class Menu {
	
	
	private BookDao bookDao = new BookDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display the list of books.", 
			"Display one book and its info.", 
			"Add a book to the list.", 
			"Edit book information.",
			"Remove a book from the list.");
	
	public void start() {
		//user select option from printed menu
		String selection = "";
		
		//loop over menu so user can continue to choose
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayBookList();
				} else if (selection.equals("2")) {
					displayBook();
				} else if (selection.equals("3")) {
					//addBook();
				} else if (selection.equals("4")) {
					//editBook();
				} else if (selection.equals("5")) {
					//deleteBook();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Press enter to continue: ");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("What would you like to do? Select an option:\n--------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			//prints out each number for user choice
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayBookList() throws SQLException {
		List<Books> books = bookDao.getBooks();
		for (Books book : books) {
			System.out.println(book.getBookId() + ": " + book.getTitle());
		}
	}
	
	private void displayBook() throws SQLException {
		System.out.print("Enter book ID to display: ");
		int id = Integer.parseInt(scanner.nextLine());
		Books books = bookDao.getBookById(id);
		System.out.println(books.getBookId() + ": " + books.getTitle());
		
	}

	

}
