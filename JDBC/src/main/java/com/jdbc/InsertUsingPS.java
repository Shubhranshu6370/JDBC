package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPS {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = DatabaseConnection.getDbConnection();
				Scanner sc = new Scanner(System.in))
		{
			String query = "INSERT INTO USER(id,name,email)VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println("Enter user");
		}
	}

}
