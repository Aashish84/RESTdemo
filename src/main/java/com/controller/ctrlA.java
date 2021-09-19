package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.databaseservice.DBConnection;
import com.controller.databaseservice.DBDisplay;
import com.controller.databaseservice.DBUpdatepost;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@WebServlet("/ctrlA/*")
public class ctrlA extends HttpServlet {
    User obj;
    String s;
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
	    response.setContentType("application/json");
	    String tmpid = request.getPathInfo();
		Gson g = new Gson();
	    	
		if(tmpid!=null && tmpid.length()>1) {
			int id = 0;
			if(tmpid.lastIndexOf("/")!=0) {
				id  = Integer.parseInt(tmpid.substring(1,tmpid.indexOf("/",1)));
			}else {
				id  = Integer.parseInt(tmpid.substring(1));
			}
			
			DBDisplay obj = new DBDisplay();
			User us = obj.displayOneData(id);
			String userJson = g.toJson(us);
			out.print(userJson);
		}else {
			JsonArray jarr = new JsonArray();
			DBDisplay ob = new DBDisplay();
        	ArrayList <User> arr = ob.displayAllData();
        	int i=0;
        	while(i!=arr.size()) {
        		User obu = arr.get(i);
        		String users = g.toJson(obu);
        		jarr.add(users);
        		i++;
        	}
        	out.print(jarr);
		}
        
//single json data from array
//        for(int i=0;i<jarr.size();i++) {
//        	out.print(jarr.get(i));
//        }
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		 String x=null;
	        if(br!=null){
	            x=br.readLine();
	        }
	        Gson g = new Gson();
	        obj = g.fromJson(x,User.class);
	        DBUpdatepost obu = new DBUpdatepost(obj);
	        if(obu.updateReport()) {
	        	this.s = "no error";
	        }else {
	        	this.s="update not done";
	        }
	}

}
