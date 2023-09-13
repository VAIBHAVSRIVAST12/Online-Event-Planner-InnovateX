package com.event.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {
	private static Connection conn = null;
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/hsbc23";;
		try {
			conn = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
