package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//class for connecting to the database
	static Connection conn;
	static {
		try {
			//step 1
			//org.postgresql.Driver
			//org.h2.driver
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static Connection makeConnection() throws SQLException {
		//step 2
		//host url
		//host username
		//host password
		//jdbc:postgresql://bank-p0.czewg1ryswrr.us-east-1.rds.amazonaws.com/bank_p0";
		//jdbc:postgresql://localhost:5432/bank_p0";
		String connectionUrl = "jdbc:postgresql://bank-p0.czewg1ryswrr.us-east-1.rds.amazonaws.com/bank_p0";
		String userName = "postgres";
		String password = "Postgresql1";
		
		
//		String connectionUrl = "jdbc:h2:mem:bank_p0";
//		String userName = "sa";
//		String password = "";
		if (conn== null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		}
		
		return conn;
		
	}
}
