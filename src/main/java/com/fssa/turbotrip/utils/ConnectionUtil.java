package com.fssa.turbotrip.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// Private constructor to prevent instantiation
	private ConnectionUtil() {
		// Do nothing (empty constructor)
	}

	// Call the database connection
	public static Connection getConnection() {

		// Database URL and credentials
//		final String dbUrl;
//		final String dbUser;
//		final String dbPassword;
//
//		dbUrl = System.getenv("DB_URL");
//		dbUser = System.getenv("DB_USER");
//		dbPassword = System.getenv("DB_PASSWORD");
 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/gowtham_sathyamoorthy_corejava_project", "root", "Amma@123");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Connect to Database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database Driver class Not found", e);
		}
	}

}