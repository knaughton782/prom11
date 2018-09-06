package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.TeamDao;
import entity.Book;
import entity.Team;

public class Menu {
	
	
	private BookDao bookDao = new BookDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display a List of Books", 
			"Display a Book", 
			"Add a Book", 
			"Edit Book Information",
			"Remove a Book");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayBookList();
				} else if (selection.equals("2")) {
					displayBook();
				} else if (selection.equals("3")) {
					addBook();
				} else if (selection.equals("4")) {
					editBook();
				} else if (selection.equals("5")) {
					deleteBook();
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
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayBookList() throws SQLException {
		List<Book> classes = bookDao.getBooks();
		for (Book book : books) {
			System.out.println(book.getBooks() + ": " + book.getTitle());
		}
	}
	
	private void displayBook() throws SQLException  {
		System.out.print("Enter book id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Book book = bookDao.getBookById(id);
		System.out.println(book.getBookId() + ": " + book.getTitle());
		for (Book book : book.getMembers()) {
			System.out.println("\tBookId: " + member.getMemberId() + " - Name: " + member.getFirstName() + " " + member.getLastName());
		}
	}

	private void addBook() throws SQLException {
		System.out.print("Enter new book name:");
		String teamName = scanner.nextLine();
		bookDao.addNewBook(bookTitle);
	}
	
	private void editBook() throws SQLException {
		System.out.print("Enter first name of new member:");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name of new member:");
		String lastName = scanner.nextLine();
		System.out.print("Enter team id of new member:");
		int teamId = Integer.parseInt(scanner.nextLine());
		memberDao.createNewMember(firstName, lastName, teamId);
	}
	
	private void deleteTeam() throws SQLException {
		System.out.print("Enter team id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		teamDao.deleteTeamById(id);
	}
	
	
	
	

}
