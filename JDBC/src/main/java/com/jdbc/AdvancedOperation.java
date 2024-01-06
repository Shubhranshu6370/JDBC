package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AdvancedOperation {

    public static void main(String[] args) {

        // Getting the connection object
        try (Connection con = DatabaseConnection.getDbConnection(); Scanner sc = new Scanner(System.in)) {

            // Create a statement object
            Statement st = con.createStatement();

            System.out.println("Enter Student id");
            String Studentid = sc.next();

            System.out.println("Enter First name");
            String Firstname = sc.next();

            System.out.println("Enter Last name");
            String Lastname = sc.next();

            System.out.println("Enter DOB");
            String dob = sc.next();
            LocalDate date = LocalDate.parse(dob);

            System.out.println("Enter Gender");
            String gender = sc.next();

            System.out.println("Enter email");
            String email = sc.next();

            System.out.println("Enter phone number");
            String Phone = sc.next();

            boolean flag1 = Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
                    email);
            boolean flag2 = Pattern.matches("[6789]{1}[0-9]{9}", Phone);

            if (flag1 && flag2) {

                String insertQuery = "INSERT INTO student(StudentID,FirstName,LastName,DateOfBirth,Gender,Email,Phone) VALUES ('"
                        + Studentid + "','" + Firstname + "','" + Lastname + "','" + dob + "','" + gender + "','"
                        + email + "','" + Phone + "')";
                String deleteQuery = "DELETE FROM student WHERE StudentID ='" + Studentid + "'";

                int rowsAffected1 = st.executeUpdate(insertQuery);
               // int rowsAffected2 = st.executeUpdate(deleteQuery);

                System.out.println(rowsAffected1 + " row(s) inserted successfully!");
               // System.out.println(rowsAffected2 + " row(s) deleted successfully!");

            } else {
                System.out.println("Invalid phone number and email");
            }

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
