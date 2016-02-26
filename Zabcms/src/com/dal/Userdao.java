package com.dal;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

import com.model.Userdto;
import com.dal.Dbcon;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

public class Userdao {
//	private Connection con;
	private Statement stmt;
	ResultSet rs;
	
	private Connection connection;
	public Userdao(ServletContext ctx){
		connection = Dbcon.getConnection(ctx);
		System.out.println(connection);
		
	}
	
	public boolean checkUser(Userdto um){
		boolean flag = false;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(" select * from useraccount where email= '"+um.getEmail()+"' and password= '"+um.getPassword()+"' ");
			while(rs.next()){
				flag = true;
				um.setEmail(rs.getString("useraccount"));
				//session.setAttribute("uname", rs.getString("user"));
				//session.setAttribute("status", check);
				
			}
//			else{
//            	System.out.println("Failed");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean addUser(Userdto um){
		boolean flag = false;
		String username,password,email,full_name;
		username = um.getUsername();
		password = um.getPassword();
		email = um.getEmail();
		full_name = um.getFull_name();
		String query = "insert into useraccount(username,password,email,full_name) values('"+username+"', '"+password+"', '"+email+"', '"+full_name+"')";
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(query);
			System.out.println("User Registered in DB");
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
