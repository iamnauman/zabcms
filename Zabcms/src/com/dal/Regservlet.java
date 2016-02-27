package com.dal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.Userdao;
import com.model.Userdto;
@WebServlet("/Regservlet")
public class Regservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   private Regservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

   RequestDispatcher dis;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username,full_name,password,email;
		username = request.getParameter("user");
		password = request.getParameter("pass");
		email = request.getParameter("email");
		full_name = request.getParameter("fname");
		System.out.println("Reg servlet: "+username+email+full_name);
		Userdto um = new Userdto();
		um.setEmail(email);
		um.setUsername(username);
		um.setFull_name(full_name);
		um.setPassword(password);
		Userdao uDao = new Userdao(getServletContext());
		if(uDao.addUser(um)){
			dis = request.getRequestDispatcher("register.html");
			dis.forward(request, response);
			System.out.println("Registered");
		}
		else{
			dis = request.getRequestDispatcher("error.jsp");
			dis.forward(request, response);
			System.out.println("Not Registered");
		}
						
	}

}



