package com.aditya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aditya.model.Users;

public class UsersDAO {

	private static final String INSERT_USER = "insert into users values(?,?,?);";
	private static final String UPDATE_USER = "update users set name=?,city=? where id=?;";
	private static final String GET_USER="select * from users where id=?";
	private static final String LIST_USERS = "select * from users;";
	private static final String DELETE_USER = "delete from users where id=?";
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@2801#R";

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}

	public void insertUser(Users user) {
		try {
			Connection connection = UsersDAO.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Users getUserByid(int id)
	{
		Users user=new Users();
		try {
			Connection connection=UsersDAO.getDBConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(GET_USER);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setName(resultSet.getString("city"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	public boolean updateUser(Users user) {
		int rowUpdated = 0;
		try {
			Connection connection = UsersDAO.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getCity());
			preparedStatement.setInt(3, user.getId());
			rowUpdated = preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowUpdated > 0;
	}

	public List<Users> listUsers() {
		List<Users> users = new ArrayList<>();
		try {

			Connection connection = UsersDAO.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(LIST_USERS);
			while (resultSet.next()) {
				Users user = new Users();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setCity(resultSet.getString(3));
				users.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}

	public boolean deleteUser(int id) {
		int rowDeleted = 0;
		try {
			Connection connection = UsersDAO.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowDeleted > 0;
	}

}
