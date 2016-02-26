package com.dal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Userdto;
import com.dal.Userdao;
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   RequestDispatcher dis;
   
  /* private Loginservlet() {
        super();
       
    }*/

	
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username,password;
		username=request.getParameter("username");
		password=request.getParameter("password");
		Userdao uDao = new Userdao(getServletContext());
		Userdto um = new Userdto();
		um.setUsername(username);
		um.setPassword(password);
		System.out.println("Login Servlet:"+um.getUsername());
		if(uDao.checkUser(um)){
			System.out.println("Logged In");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			System.out.println("Dispatching");
			dis = request.getRequestDispatcher("HistoryServlet?action=showHistory");
			dis.forward(request, response);
			System.out.println("Done");
		}
		else{
			System.out.println("Error");
			dis = request.getRequestDispatcher("error.html");
			dis.forward(request, response);
		}
	}



	}


