package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	// declare DB connection parameters
    private static String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static String DB_Username = "root";
    private static String DB_Password = "19712Huyen";
    
    public static Connection getConnection() {
    	Connection connect = null;
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	connect = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return connect;
    }
}
