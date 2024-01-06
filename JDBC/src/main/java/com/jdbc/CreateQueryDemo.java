package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateQueryDemo {

	public static void main(String args[]) {
		
		//getting the connection object
		   Connection con = DatabaseConnection.getDbConnection();
		
		//create statement object
		try {
			Statement st = con.createStatement();
			
			//write the query
			String createQuery = "CREATE TABLE USER(id INT PRIMARY KEY, name VARCHAR(30))";
		
			//execute the query
			
		}
		
	catch (SQLException e) {
	    e.printStackTrace();
	}
	}
}
