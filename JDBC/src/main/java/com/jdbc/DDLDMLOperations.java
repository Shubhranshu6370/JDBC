package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class DDLDMLOperations {
	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
                //Using try-catch block
	        try {
	            // Load the JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish a connection to the database
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kistfaculty", "root", "6370");

	            // Create a statement object
	            stmt = conn.createStatement();

	            // Drop table if it exists
	            String sql = "DROP TABLE IF EXISTS teacher";
	            stmt.executeUpdate(sql);

	            // Create table
	            sql = "CREATE TABLE teacher" +
	                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
	                    "name VARCHAR(20), " +
	                    "subject VARCHAR(30), " +
	                    "address VARCHAR(20), " +
	                    "email VARCHAR(40) " +
	                    ")";

	            stmt.executeUpdate(sql);
	            System.out.println("Table created successfully...");

	            // Alter table
	            sql = "ALTER TABLE teacher " +
	                    "ADD phn_no BIGINT, " +
	                    "MODIFY name VARCHAR(20) NOT NULL";

	            stmt.executeUpdate(sql);
	            System.out.println("Table altered successfully...");
	            System.out.println();

	            // Insert data
	            sql = "INSERT INTO teacher (id, name, subject, address, email, phn_no) " +
	                    "VALUES (101, 'Johnsan pradhan', 'Physics', 'Cuttack', 'johnsan@gmail.com', '9572768686'), "
	                    + "(102, 'Durgamadhab roy', 'Chemistry', 'Bhubaneswar', 'durga@gmail.com', '6785839525'), "
	                    + "(103, 'Sonu sharma', 'Zoology', 'Rourkela', 'sonu@gmail.com', '7946728398'), "
	                    + "(104, 'Anish sahoo', 'Botany', 'Koraput', 'anish@gmail.com', '6544528398'), "
	                    + "(105, 'Subhashree mohapatra', 'Mathematics', 'Sambalpur', 'subhashree@gmail.com', '7685839525') ";
	            stmt.executeUpdate(sql);
	            printData(stmt);
	            System.out.println("Data inserted successfully...");
	            System.out.println();

	          //Update data from table
	            sql = "UPDATE teacher " +
	                    "SET subject = 'History', email= 'mohapatrasub@gmail.com' " +
	                    "WHERE id = 105";
	            stmt.executeUpdate(sql);
	            printData(stmt);
	            System.out.println("Data updated successfully...");
	            System.out.println();
	            
	            // Delete data from table
	            sql = "DELETE FROM teacher WHERE id = 104";
	            stmt.executeUpdate(sql);
	            printData(stmt);
	            System.out.println("Data deleted successfully...");
	            System.out.println();

	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) {
	                    conn.close();
	                }
	            } catch (SQLException se) {
	            }
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    }

	    private static void printData(Statement stmt) throws SQLException {
	        ResultSet rs = stmt.executeQuery("SELECT * FROM teacher");
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String subject = rs.getString("subject");
	            String address = rs.getString("address");
	            String email = rs.getString("email");
	            Long phn_no = rs.getLong("phn_no");
             
	            //execute the teachers details
	            System.out.println("ID: " + id + ", Name: " + name + ", Subject: " + subject + ", Address: " + address
	                    + ", Email: " + email+ ", Phone: "+ phn_no);
	        }
	    }
	}

	
//*------------------------------------OUTPUT----------------------------------------//
//	Table created successfully...
//	Table altered successfully...
//
//	ID: 101, Name: Johnsan pradhan, Subject: Physics, Address: Cuttack, Email: johnsan@gmail.com, Phone: 9572768686
//	ID: 102, Name: Durgamadhab roy, Subject: Chemistry, Address: Bhubaneswar, Email: durga@gmail.com, Phone: 6785839525
//	ID: 103, Name: Sonu sharma, Subject: Zoology, Address: Rourkela, Email: sonu@gmail.com, Phone: 7946728398
//	ID: 104, Name: Anish sahoo, Subject: Botany, Address: Koraput, Email: anish@gmail.com, Phone: 6544528398
//	ID: 105, Name: Subhashree mohapatra, Subject: Mathematics, Address: Sambalpur, Email: subhashree@gmail.com, Phone: 7685839525
//	Data inserted successfully...
//
//	ID: 101, Name: Johnsan pradhan, Subject: Physics, Address: Cuttack, Email: johnsan@gmail.com, Phone: 9572768686
//	ID: 102, Name: Durgamadhab roy, Subject: Chemistry, Address: Bhubaneswar, Email: durga@gmail.com, Phone: 6785839525
//	ID: 103, Name: Sonu sharma, Subject: Zoology, Address: Rourkela, Email: sonu@gmail.com, Phone: 7946728398
//	ID: 104, Name: Anish sahoo, Subject: Botany, Address: Koraput, Email: anish@gmail.com, Phone: 6544528398
//	ID: 105, Name: Subhashree mohapatra, Subject: History, Address: Sambalpur, Email: mohapatrasub@gmail.com, Phone: 7685839525
//	Data updated successfully...
//
//	ID: 101, Name: Johnsan pradhan, Subject: Physics, Address: Cuttack, Email: johnsan@gmail.com, Phone: 9572768686
//	ID: 102, Name: Durgamadhab roy, Subject: Chemistry, Address: Bhubaneswar, Email: durga@gmail.com, Phone: 6785839525
//	ID: 103, Name: Sonu sharma, Subject: Zoology, Address: Rourkela, Email: sonu@gmail.com, Phone: 7946728398
//	ID: 105, Name: Subhashree mohapatra, Subject: History, Address: Sambalpur, Email: mohapatrasub@gmail.com, Phone: 7685839525
//	Data deleted successfully...

