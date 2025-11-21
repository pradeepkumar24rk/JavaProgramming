package config;

import java.sql.*;
public class DBConnection {
	private static Connection connection;
	
	private DBConnection() {}
	
	public static Connection getConnection() {

			try {
				Class.forName("org.sqlite.JDBC");
				String url = "jdbc:sqlite:C:\\Users\\prade\\MySQLiteDB";
				connection = DriverManager.getConnection(url);
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return connection;
	}
}
