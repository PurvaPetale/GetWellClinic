package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.dbo.UserDbo;
import com.entity.User;

@WebServlet("/user_register")

public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String address = req.getParameter("address");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");

			User u = new User(fullName, email, password, address, gender, age);

			UserDbo dbo = new UserDbo(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean f = dbo.register(u);

			if (f) {

				session.setAttribute("sucMsg", "Registration Successful");
				resp.sendRedirect("signup.jsp");
				// System.out.println("Registration Successful");
			} else {

				session.setAttribute("errorMsg", "Something went wrong...Please try again");
				resp.sendRedirect("signup.jsp");
				// System.out.println("Something went wrong...Try again");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
