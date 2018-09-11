package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Books;

public class BookDao {
	
	private Connection connection;
	private final String GET_BOOKS_QUERY = "SELECT * FROM books";
	private final String GET_BOOK_BY_ID_QUERY = "SELECT * FROM books WHERE id = ?";
	
	public BookDao() {
		connection = DBConnection.getConnection();
	}

	public List<Books> getBooks() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_BOOKS_QUERY).executeQuery();
		List<Books> books = new ArrayList<Books>();
		
//		while (rs.next()) {
//			books.add(e)
//		}
		return books;
	}
	
		
	public Books getBookById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BOOK_BY_ID_QUERY);
		//column 1, variable based on id passed in
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return getBookById(rs.getInt(1));
	}

}