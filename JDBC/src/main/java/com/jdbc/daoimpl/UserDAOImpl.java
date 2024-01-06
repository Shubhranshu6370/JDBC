package com.jdbc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DatabaseConnection;
import com.jdbc.dao.UserDAO;
import com.jdbc.dto.User;

//Concrete DAO
public class UserDAOImpl implements UserDAO{

	Connection con;
	
	@Override
	//Create a constructor for adding user details
	public void addUser(User user) {
		
		//Using try-catch block
		try
		{
			con = DatabaseConnection.getDbConnection();
			
			con.setAutoCommit(false); //auto-commit false
			
			//Take query using INSERT statement
			String insertUser = "INSERT INTO USER(id,name,email) VALUES(?,?,?)";
			
			//Using PreparedStatement
			PreparedStatement ps = con.prepareStatement(insertUser);
			
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			
			int rowAffected = ps.executeUpdate();
			
			//Using if-else loop
			if(rowAffected>0)
			{
				con.commit(); //save the changes
				System.out.println(rowAffected+" user added successfully!");
			}
			else
			{
				con.rollback(); //rollback to previous commit/rollback
				System.out.println("User details was not added.");
			}	
		}
		catch(SQLException e)
		{		
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		//Using finally statement
		finally
		{
			try {
				if(con!=null)
					con.close(); //closing the connection
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	//Create a constructor for get a user deatils by id
	public User getUserById(String id) {
		
		//Take user value as null
		User user = null;
		
		//Using try with catch block
		try
		{
			con = DatabaseConnection.getDbConnection();
			
			con.setAutoCommit(false); //auto-commit false
			
			String getUser = "SELECT * FROM user where id=?";
			
			PreparedStatement ps = con.prepareStatement(getUser);
			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			//Using if-else statement
			if(rs.next())
			{
				user = new User();
				
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
			else
			{
				System.out.println("User details not found!!");
			}
			
			con.commit();//save the changes
			
			
		}
		catch(SQLException e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		//using finally statement
		finally
		{
			try {
				if(con!=null)
					con.close(); //closing the connection
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return user; //return user
	}

	@Override
	//Create a constructor for getting all user details
	public List<User> getAllUsers() {
		
		User user = null;
		List<User> users = new ArrayList<>();
		
		//Using try with catch block
		try
		{
			con = DatabaseConnection.getDbConnection();
			
			con.setAutoCommit(false); //auto-commit false
			
			Statement st = con.createStatement();
			
			String getAllUsers = "SELECT * FROM user";
			
			ResultSet rs = st.executeQuery(getAllUsers);
			
			//Using While loop
			while(rs.next())
			{
				user = new User();
				
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				users.add(user); //adding user details to the list
			}
			
			con.commit();//save the changes
			
		}
		catch(SQLException e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		//using fianlly statement
		finally
		{
			try {
				if(con!=null)
					con.close(); //closing the connection
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return users; //return users
	}
   @Override
    //Create a constructor for update user details
	public void updateUser(User user) {
		
		//update user set name = ?, email = ? where id = ?
	
		 //Using try with resource
		    try (Connection con = DatabaseConnection.getDbConnection()) {
		        con.setAutoCommit(false);//auto-commit false
		        
         //Update query using preparedstatement
		        String updateUserQuery = "UPDATE USER SET name=?, email=? WHERE id=?";
		        
		        try (PreparedStatement ps = con.prepareStatement(updateUserQuery)) {
		            ps.setString(1, user.getName());
		            ps.setString(2, user.getEmail());
		            ps.setString(3, user.getId());

		            int rowAffected = ps.executeUpdate();
		            
          //Using if-else statement
		            
		            if (rowAffected > 0) {
		                con.commit();
		                System.out.println(rowAffected + " user updated successfully!");
		                
		            } 
		            else {
		                con.rollback();
		                System.out.println("User details were not updated.");
		            }
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace(); // Handle exceptions appropriately for your application
		    }
		}
		
	@Override
	//Create a constructor for delete user details
	public void deleteUserById(String id) {
		
		//Using try with resource
	    try (Connection con = DatabaseConnection.getDbConnection()) {
	        con.setAutoCommit(false);//auto-commit false

	        String deleteUserQuery = "DELETE FROM USER WHERE id=?";
	        
	        try (PreparedStatement ps = con.prepareStatement(deleteUserQuery)) {
	            ps.setString(1, id);

	            int rowAffected = ps.executeUpdate();
	            
         //Using if-else statement
	            if (rowAffected > 0) {
	                con.commit();
	                System.out.println(rowAffected + " user deleted successfully!");
	            } else {
	                con.rollback();
	                System.out.println("User with ID " + id + " not found.");
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	}

}
