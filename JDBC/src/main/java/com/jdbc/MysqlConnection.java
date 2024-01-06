package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlConnection {

	public static void main(String[] args) {
		
       //Getting the connection object		
		try(Connection con = DatabaseConnection.getDbConnection())   //try with resource
		{
		   
		 //Creating a statement object
			Statement st = con.createStatement();
			
			
		//Write the  query
			String query = "SELECT * from student";
			
		//Execute the query	
			ResultSet res = st.executeQuery(query);
			
			
		//print retrive data using while loop
			while(res.next()) {
			String StudentID = res.getString("StudentID");
			String FirstName = res.getString("FirstName");
			String LastName = res.getString("LastName");
			String DateOfBirth = res.getString("DateOfBirth");
			String Gender = res.getString("Gender");
			String Email = res.getString("Email");
			String Phone =res.getString("Phone");
			System.out.println("========================");
			
			System.out.println("StudentID:"+ StudentID );
			System.out.println("FirstName:"+ FirstName);
			System.out.println("LastName:"+ LastName);
			System.out.println("DateOfBirth:"+DateOfBirth);
			System.out.println("Gender:"+Gender);
			System.out.println("Email:"+Email);
			System.out.println("Phone:"+Phone);
			}
		//Close resultset,connection and statement	
		res.close();
		con.close();
		st.close();
		}
		catch(SQLException e){
		     e.printStackTrace();	
		}
	}

}


//----------------------OUTPUT-----------------------------//
//StudentID:S101
//FirstName:John
//LastName:Doe
//DateOfBirth:2000-10-10 00:00:00
//Gender:M
//Email:john@example.com
//Phone:9878457945
//========================
//StudentID:S102
//FirstName:Jane
//LastName:Smith
//DateOfBirth:2013-08-08 00:00:00
//Gender:M
//Email:jane@example.com
//Phone:9977457745
//========================
//StudentID:S103
//FirstName:Alice
//LastName:Johnson
//DateOfBirth:2011-09-08 00:00:00
//Gender:F
//Email:alice@example.com
//Phone:9876457845
//========================
//StudentID:S104
//FirstName:Anna
//LastName:Doe
//DateOfBirth:2011-07-08 00:00:00
//Gender:F
//Email:Anna.doe@india.com
//Phone:9876457842
//========================
//StudentID:S105
//FirstName:Peter
//LastName:Parker
//DateOfBirth:2011-06-05 00:00:00
//Gender:M
//Email:p_parker@example.com
//Phone:9276457843
//========================
//StudentID:S106
//FirstName:Tanmay
//LastName:Raj
//DateOfBirth:2000-09-08 00:00:00
//Gender:M
//Email:tanmay@example.com
//Phone:7686459720

