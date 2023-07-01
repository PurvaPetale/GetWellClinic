package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbo.UserDbo;
import com.db.DBConnect;

@WebServlet("/userChangePassword")
public class changePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid = Integer.parseInt(req.getParameter("uid"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");

		UserDbo dbo = new UserDbo(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dbo.checkOldPassword(uid, oldPassword)) {

			if (dbo.changePassword(uid, newPassword)) {
				session.setAttribute("succMsg", "Password Changed Sucessfully");
				resp.sendRedirect("change_password.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("change_password.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Incorrect Old Password");
			resp.sendRedirect("change_password.jsp");
		}

	}

}

