package mydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectMySQL {
	// declare DB connection parameters
    private static String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static String DB_USERNAME = "root";
    private static String DB_PASSWORD = "19712Huyen";
 
    public static void main(String args[]) {
        try {
            // connect to MySQL database  
            Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            // create statement
            Statement stm = con.createStatement();
			// create SQL query
			String query = "SELECT * FROM student";
            // execute SQL query
            ResultSet rs = stm.executeQuery(query);
            // display data to console
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt(1));
				System.out.println("Student Name:  " + rs.getString(2));
				System.out.println("Student Birthday: " + rs.getString(3));
				System.out.println("Student Address: " + rs.getString(4));
				System.out.println("Student Email: " + rs.getString(5));
				System.out.println("Student PhoneNumber: " + rs.getString(6));
            }
            // close JDBC connection
            con.close();
        } catch (Exception ex) {
			// print error if failure
            ex.printStackTrace();
        }
    }
 
	// establish connection to a MySQL database
    public static Connection getConnection(String dbUrl, String dbUsername, String dbPassword) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connect to MySQL database successfully !");
        } catch (Exception ex) {
            System.out.println("Connect to MySQL database failed !");
			// print error if failure
            ex.printStackTrace();
        }
        return con;
    }
}