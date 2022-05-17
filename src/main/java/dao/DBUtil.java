package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//class for connecting to the database
	static Connection conn;
	static {
		try {
	
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static Connection makeConnection() throws SQLException {
		
		String connectionUrl = "jdbc:postgresql://bank-p0.czewg1ryswrr.us-east-1.rds.amazonaws.com/bank_p0";
		String userName = "postgres";
		String password = "Postgresql1";
		
		if (conn== null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		}
		
		return conn;
		
	}
}
