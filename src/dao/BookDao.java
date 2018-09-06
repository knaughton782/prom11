package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookDao {
	
	private Connection connection;
	private final String GET_BOOKS_BY_BOOK_ID_QUERY = "SELECT * FROM books WHERE id = ?";
	private final String DELETE_BOOKS_BY_BOOK_ID_QUERY = "DELETE FROM books WHERE id = ?";
	private final String CREATE_NEW_BOOK_QUERY = "INSERT INTO books(title, author, description, category) VALUES(?,?,?,?)";
	private final String DELETE_BOOK_BY_ID_QUERY = "DELETE FROM books WHERE id = ?";
	
	public BookDao() {
		connection = DBConnection.getConnection();
	}

	public List<Book> getBooksById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BOOKS_BY_BOOK_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Book> books = new ArrayList<Book>();
		
		while (rs.next()) {
			books.add(new Book(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4), 
					rs.getString(5)));
		}
		
		return books;
	}
	
	public void createNewMember(String firstName, String lastName, int teamId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BOOKS_BY_BOOK_ID_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, teamId);
		ps.executeUpdate();
	}
	
	public void deleteMembersByTeamId(int teamId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BOOK_QUERY);
		ps.setInt(1, teamId);
		ps.executeUpdate();
	}
	
	public void deleteMemberById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BOOK_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}