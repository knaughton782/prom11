package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/books";
	private final static String USERNAME = "user1";
	private final static String PASSWORD = "password1";
	private static Connection connection;
	private static DBConnection instance; //singleton pattern
	
	private DBConnection(Connection connection) {
		//cannot construct an instance of this class from outside this class: using a singleton
		this.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			//if its null, it creates the connection
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection); //call constructor
				System.out.println("Connected to DB successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//if it is not null, it returns the already created connection
		return DBConnection.connection;
	}

}
