package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aditya.database_connection.Database_Connection;

public class Person_DAO {

	public static void insertPerson(String name, String city) {
		try {
			Connection connection = Database_Connection.dB_Connection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into jsp_data (name,city) values(?,?);");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, city);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updatePerson(String name, String city, int id) {
		try {
			Connection connection = Database_Connection.dB_Connection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update jsp_data set name=?,city=? where id=?;");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, city);
			preparedStatement.setInt(3, id);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet viewUsers() {
		ResultSet resultSet = null;
		try {
			Connection connection = Database_Connection.dB_Connection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from jsp_data;");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public static ResultSet getUserById(int id) {
		ResultSet resultSet = null;
		try {
			Connection connection = Database_Connection.dB_Connection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from jsp_data where id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public static void deleteUserById(int id) {
		try {
			Connection connection = Database_Connection.dB_Connection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from jsp_data where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
