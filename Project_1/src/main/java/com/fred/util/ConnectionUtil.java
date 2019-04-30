package com.fred.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			String[] creds= System.getenv("DBProps").split(";");
			conn = DriverManager.getConnection(
					creds[0],
					creds[1],
					creds[2]
					);
			System.out.println("==========<LOADING>========");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	
}
