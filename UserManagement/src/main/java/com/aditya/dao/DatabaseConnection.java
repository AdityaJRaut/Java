package com.aditya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	final private static String URL = "jdbc:mysql://localhost:3306/employee_management";
	final private static String USERNAME = "root";
	final private static String PASSWORD = "root";

	public static Connection getDBConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Database Driver not found!", e);
		}
		

	}
}
