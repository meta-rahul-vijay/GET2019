package com.parkingsystem.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is connection factory class This gives the connection object
 * @author Rahul
 *
 */
public class ConnectionFactory {

	// This represent the diver
	static final String DRIVER = "com.mysql.jdbc.Driver";
	// This represent the user name
	static final String USER_NAME = "root";
	// This represent the password
	static final String PASSWORD = "1234";
	// This represent the url of database
	static final String URL = "jdbc:mysql://localhost:3306/employee";

	/**
	 * This method return the connection object to connect with database
	 * @return object of Connection class
	 * @throws Exception when driver class not found or can't create connection
	 */
	public static Connection getConnection() throws Exception {

		try {
			Connection conn = null;
			Class.forName(DRIVER).newInstance();
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}
