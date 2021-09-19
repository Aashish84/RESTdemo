package com.controller.databaseservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.controller.User;

public class DBUpdatepost {
	int i = 0;
	public DBUpdatepost(User b){
		if(b.getName()!=null) {
			String query = "update User set name = ? where id = ?";
			DBConnection ob = new DBConnection();
			Connection con = ob.getConnection();
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,b.getName());
				pstmt.setInt(2, b.getId());
				i =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean updateReport() {
		return i!=0 ;
	}
}
