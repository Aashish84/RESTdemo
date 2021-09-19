package com.controller.databaseservice;


import java.sql.*;

import com.controller.User;

public class DBAddpost {
	int i = 0;
	public DBAddpost(User c) {
		String query = "insert into user (name) values(?)";
		DBConnection ob = new DBConnection();
		Connection con = ob.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, c.getName());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addReport() {
		if(i!=0) {
			return true;
		}
		return false;
	}
	
}
