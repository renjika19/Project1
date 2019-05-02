package com.fred.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				/*
				 * In the old days, JDBC would require you to manually add the
				 * oracle ojdbc driver class at runtime.
				 * Class.forname will explicitly search and load the detailed class
				 * at runtime, as opposed to Java naturally loading the class itself.
				 */
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			String[] creds = System.getenv("DBProps").split(";");
			conn = DriverManager.getConnection(
					creds[0],
					creds[1],
					creds[2]
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

