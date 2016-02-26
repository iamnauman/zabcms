package com.dal;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;



	public class Dbcon {
		
		public Object clone() throws CloneNotSupportedException {
		    throw new CloneNotSupportedException(); 
		}
	private Dbcon(){
			
		}
		private static Connection connection=null;
	public static final Connection getConnection(ServletContext context){
		if (connection !=null)
		return connection;
		

		
		
			/**
			 * 
			 */
		 else {
	         try {
	           
	           
	             String driver = context.getInitParameter("jdbc.driver");
	             String url = context.getInitParameter("jdbc.url");
	             String user = context.getInitParameter("jdbc.username");
	             String password = context.getInitParameter("jdbc.password");
	             Class.forName(driver);
	             connection = DriverManager.getConnection(url, user, password);
	         } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return connection;
	     }

	 }
	}


