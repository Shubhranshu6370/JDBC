package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {
	
	static Connection con = null;
	
	public static Connection getDbConnection()
	{
		try {
			
			String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";
			String userName = "root";
			String password = "6370";
			
			con = DriverManager.getConnection(url, userName, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}