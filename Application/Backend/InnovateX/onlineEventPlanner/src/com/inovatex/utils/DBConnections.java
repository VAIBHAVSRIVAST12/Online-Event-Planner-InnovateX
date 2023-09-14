package com.inovatex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {
	private static Connection conn = null;
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/codefury";
		try {
			conn = DriverManager.getConnection(url,"root","1234");
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
