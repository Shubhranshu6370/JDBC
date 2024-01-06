package com.jdbc.dao;

import java.util.List;

import com.jdbc.dto.User;

//DAO
public interface UserDAO {

//Method to add user details	
void addUser(User user);

//Method to get user details using id
User getUserById(String deleteUserId);

//Method to fetch all user details
List<User> getAllUsers();

//Update user details using id
void updateUser(User user);

//Delete user details using id
void deleteUserById(String deleteUserId);

}
