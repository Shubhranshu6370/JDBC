package com.jdbc;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.UserDAO;
import com.jdbc.daoimpl.UserDAOImpl;
import com.jdbc.dto.User;

public class Main {

    public static void main(String[] args) {
    	
       //Using scanner class for user input
        Scanner sc = new Scanner(System.in);
        
        UserDAO userDao = new UserDAOImpl();
        
        User user = null;
        
        int choice;

        //Using do while loop
        do {
            System.out.println("1) Add a new user\n" + "2) Get user details using id\n" + "3) Get all users\n"
                    + "4) Update user\n" + "5) Delete user by id\n" + "6) Exit");
            System.out.println("Enter the choice:");
           //Using if-else statement
           if (sc.hasNextInt()) {
                choice = sc.nextInt();
           } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume the invalid input
             continue;
           }
           //Using Switch case
           
            switch (choice) {
                case 1:
                    // add user method
                	
                    System.out.println("Enter id: ");
                    String id = sc.next();
                    sc.nextLine();
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter email: ");
                    String email = sc.next();

                    user = new User(id, name, email);
                    userDao.addUser(user);
                    System.out.println();
                    break;

                case 2:
                    // Get user details using id
                	
                    System.out.println("Enter id: ");
                    id = sc.next();
                    user = userDao.getUserById(id);
                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("User not found.");
                    }
                    System.out.println();
                    break;

                case 3:
                	//Get all user details
                	
                    List<User> users = userDao.getAllUsers();
                    for (User u : users) {
                        System.out.println(u);
                    }
                    System.out.println();
                    break;

                case 4:
                	//Update user details using new user id
                	
                    System.out.println("Enter the ID of the user to update:");
                    String updateUserId = sc.next();
                    sc.nextLine(); // Consume the newline character left by nextInt()

                    User updateUser = userDao.getUserById(updateUserId);
                    if (updateUser != null) {
                        System.out.println("Enter new name:");
                        String newName = sc.nextLine();
                        System.out.println("Enter new email:");
                        String newEmail = sc.next();

                        updateUser.setName(newName);
                        updateUser.setEmail(newEmail);

                        userDao.updateUser(updateUser);
                        System.out.println("User updated successfully!");
                    } 
                    else {
                        System.out.println("User with ID " + updateUserId + " not found.");
                    }
                    System.out.println();
                    break;

                case 5:
                	//Delete user detail by using one user id
                	
                    System.out.println("Enter the ID of the user to delete:");
                    String deleteUserId = sc.next();

                    User deleteUser = userDao.getUserById(deleteUserId);
                    if (deleteUser != null) {
                        System.out.println("Are you sure you want to delete the following user?");
                        System.out.println(deleteUser);
                        System.out.println("Enter 'yes' to confirm deletion:");
                        String confirmDelete = sc.next().toLowerCase();

                        if (confirmDelete.equals("yes")) {
                            userDao.deleteUserById(deleteUserId);
                            System.out.println("User deleted successfully!");
                        } else {
                            System.out.println("Deletion canceled.");
                        }
                    } else {
                        System.out.println("User with ID " + deleteUserId + " not found.");
                    }
                    System.out.println();
                    break;

                case 6:
                	//Exit from the switch case
                    System.out.println("Thank you for visiting!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        } while (true);

    }
}


//----------------------------------------OUTPUT---------------------------------------------------//
//1) Add a new user
//2) Get user details using id
//3) Get all users
//4) Update user
//5) Delete user by id
//6) Exit
//Enter the choice:
//1
//Enter id: 
//S104
//Enter name: 
//Gyananjaya
//Enter email: 
//gyananjaya@gmail.com
//1 user added successfully!
//
//1) Add a new user
//2) Get user details using id
//3) Get all users
//4) Update user
//5) Delete user by id
//6) Exit
//Enter the choice:
//
//2
//Enter id: 
//S102
//User(id=S102, name=Ashutosh, email=ashutosh@gmail.com)
//
//1) Add a new user
//2) Get user details using id
//3) Get all users
//4) Update user
//5) Delete user by id
//6) Exit
//Enter the choice:
//3
//User(id=S101, name=Babrubahan, email=babrubahan@gmail.com)
//User(id=S102, name=Ashutosh, email=ashutosh@gmail.com)
//User(id=S103, name=Chandan, email=chandan@gmail.com)
//User(id=S104, name=Gyananjaya, email=gyananjaya@gmail.com)
//
//1) Add a new user
//2) Get user details using id
//3) Get all users
//4) Update user
//5) Delete user by id
//6) Exit
//Enter the choice:
//4
//Enter the ID of the user to update:
//S103
//Enter new name:
//Ratikanta
//Enter new email:
//ratikanta@gmail.com
//1 user updated successfully!
//User updated successfully!
//
//1) Add a new user
//2) Get user details using id
//3) Get all users
//4) Update user
//5) Delete user by id
//6) Exit
//Enter the choice:
//5
//Enter the ID of the user to delete:
//S102
//Are you sure you want to delete the following user?
//User(id=S102, name=Ashutosh, email=ashutosh@gmail.com)
//Enter 'yes' to confirm deletion:
//yes
//1 user deleted successfully!
//User deleted successfully!
//
//1) Add a new user
//2) Get user details using id
//3) Get all users
//4) Update user
//5) Delete user by id
//6) Exit
//Enter the choice:
//6
//Thank you for visiting!!
