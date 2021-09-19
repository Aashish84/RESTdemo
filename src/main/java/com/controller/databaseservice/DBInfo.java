package com.controller.databaseservice;

public class DBInfo {
	private String url;
	private String dbname;
	private String dbusername;
	private String dbpassword;
	
	public DBInfo() {
		this.url="jdbc:mysql://localhost:3306/";
		this.dbname="java_demo";
		this.dbusername="root";
		this.dbpassword="";
	}
	
	public DBInfo(String url, String dbname, String dbusername, String dbpassword) {
		super();
		this.url = url;
		this.dbname = dbname;
		this.dbusername = dbusername;
		this.dbpassword = dbpassword;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getDbusername() {
		return dbusername;
	}
	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}
	public String getDbpassword() {
		return dbpassword;
	}
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}
	
	
}
