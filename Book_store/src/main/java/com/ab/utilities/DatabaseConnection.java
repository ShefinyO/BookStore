package com.ab.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	
	private static Connection con;
	

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			if(con == null) { // This code enable Singleton
				con = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","");
			}
				
		}
		catch(ClassNotFoundException e) {
			
			return null;
		}
		catch(SQLException e) {
			return null;
		}
		System.out.println("connection successfull");
		return con;
	}
	
	

}

