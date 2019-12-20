package com.xh.learn.sdk.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	public static void main(String[] args) {
		try {
			Connection connection = getConnection();
			System.out.println(getDatabaseProductName(connection));
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select count(1) from usr;");

			PreparedStatement statement = preparedStatement(connection, "select count(1) total from usr;");
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				System.out.println(resultSet.getInt("total"));
			}

			close(connection, statement, resultSet);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/learn", "admin", "Huawei@123");
	}

	public static String getDatabaseProductName(Connection connection) throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		return metaData.getDatabaseProductName();
	}

	public static PreparedStatement preparedStatement(Connection connection, String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}

	public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
