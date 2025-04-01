package com.project.projectfirst.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	static private Connection conn=null;
	public static Connection getConnection() {
		try{
			String url = "jdbc:mysql://localhost:3306/hotelmanagement";
		String username = "root";
		String password = "Naveen@196134";
		if(conn==null) {
		conn = DriverManager.getConnection(url, username, password);
		System.out.println("successfully connected");
		}
		}catch(Exception e) {                      
			e.printStackTrace();
		}
		return conn;
	}

}


