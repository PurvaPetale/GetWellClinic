package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.dbo.DoctorDbo;
import com.entity.Doctor;

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		
			String fullName = req.getParameter("full_name");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");
			String age = req.getParameter("age");
			String yearofex = req.getParameter("yearofex");
			
			Doctor d = new Doctor(0, fullName, dob, qualification, spec, email, mobno, password, age, yearofex);

			DoctorDbo dbo = new DoctorDbo(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dbo.registerDoctor(d)) {
				session.setAttribute("succMsg", "Doctor Added Sucessfully..");
				resp.sendRedirect("admin/doctor.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/doctor.jsp");
			}
			
			
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
	}

}
