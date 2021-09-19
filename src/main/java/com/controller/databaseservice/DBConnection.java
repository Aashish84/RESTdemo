package com.controller.databaseservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection con;
	
	public DBConnection() {
		DBInfo ob = new DBInfo();
		try {
			try {
        		Class.forName("com.mysql.jdbc.Driver");
        	} catch (ClassNotFoundException e) {
        		e.printStackTrace();
        	} 
			con=DriverManager.getConnection(ob.getUrl()+""+ob.getDbname(),ob.getDbusername(),ob.getDbpassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}

}
