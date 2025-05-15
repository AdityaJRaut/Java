package com.aditya.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {

	final private static String URL = "jdbc:mysql://localhost:3306/demo";
	final private static String USERNAME = "root";
	final private static String PASSWORD = "root";

	public static Connection dB_Connection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Database Driver not found!", e);
		}

	}
}
