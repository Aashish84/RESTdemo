package com.controller.databaseservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.controller.User;


public class DBDisplay {
	
	private String table;
	public DBDisplay() {
		this.table="user";
	}
	public DBDisplay(String table) {
		this.table=table;
	}
	
	public ResultSet displayAll() {
		ResultSet rs = null;
		String query="select * from "+table;		
		DBConnection ob = new DBConnection();
		Connection con = ob.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ArrayList<User> displayAllData() {
		ArrayList<User> temp = new ArrayList<>();
		ResultSet rs = displayAll();
            try {
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2); 
					User cob = new User(id,name);
					temp.add(cob);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return temp;
	}
	
	public User displayOneData(int id) {
		String query="select * from "+table+" where id=?";		
		User temp = null ;
		DBConnection ob = new DBConnection();
		Connection con = ob.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2); 
				User cob = new User(id1, name );
				temp=cob;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	
//	public ArrayList<Brand> displayAllCategory(String table) {
//		String query="select * from "+table;		
//		ArrayList<Brand> temp = new ArrayList<>();
//		DBConnection ob = new DBConnection();
//		Connection con = ob.getCon();
//		try {
//            PreparedStatement pstmt = con.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//            	int bid = rs.getInt(1);
//            	String name = rs.getString(2); 
//            	int cid = rs.getInt(3);
//            	Brand bob = new Brand(bid,name,cid);
//            	temp.add(bob);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//		return temp;
//	}
	
}
