package com.reporter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;


@WebServlet("/reporterLogin")
public class ReporterLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			
			if("reporter@gmail.com".equals(email)&& "reporter".equals(password))
			{
				session.setAttribute("repoObj", new User());
				resp.sendRedirect("reporter/index.jsp");
			}
			else
			{
				session.setAttribute("errorMsg", "You have entered invalid email or password");
				resp.sendRedirect("reporter_login.jsp");
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}

