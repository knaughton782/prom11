package weekEleven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ApplicationExample {

	public static void main(String[] args) {
		String connectionString = "jdbc:mysql://localhost:3306/employees";
		
		//all caps w underscore is java default for final/constants
		String SELECT_QUERY = "SELECT * FROM employees where emp_no = ?"; 
		
		Scanner scanner = new Scanner(System.in);
		
		
		//creating a connection can throw a sql exception so we create a try block
		
		try {
			Connection conn = DriverManager.getConnection(connectionString, "user1", "password1");
			System.out.println("Connected to Database");
			System.out.print("Enter employee number: ");
			
			String empNo = scanner.nextLine();
			
			//statement opens you to sql injection while prepared statement sanitizes the data
			//Statement statement = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
			ps.setString(1, empNo);
			
			//this resultset statement is used with the statement format rather than the prepared statement format
			//ResultSet rs = statement.executeQuery(SELECT_QUERY + empNo);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				System.out.println("emp_no: " 
						+ rs.getInt(1) + " dob: " 
						+ rs.getString(2) + " First Name: " 
						+ rs.getString(3)  );
			}
			
		} catch (SQLException e) {
			System.out.println("Error connecting to Database");
			e.printStackTrace();
		}
		
	}

}
