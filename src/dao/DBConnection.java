package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//not using strict singleton pattern
public class DBConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/books";
	private final static String USERNAME = "user1";
	private final static String PASSWORD = "password1";
	private static Connection connection;
	
	
	public static Connection getConnection() {
		if (connection == null) {
			//if its null, it creates the connection
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connected to DB successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//if it is not null, it returns the already created connection
		return connection;
	}

}
