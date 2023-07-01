package com.reporter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.dbo.ReporterDbo;
import com.entity.reporter;


@WebServlet("/update_leaves")
public class UpdateLeaves extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			
			String doctname = req.getParameter("doctname");
			String leavesd  = req.getParameter("leavesd");
			String leaveed  = req.getParameter("leaveed");
			String status   = req.getParameter("status");
			
			reporter d = new reporter(0, doctname,leavesd,leaveed,status, status, status);

			ReporterDbo dbo = new ReporterDbo (DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dbo.doctorLeaves(d)) {
				session.setAttribute("succMsg", "Doctor leaves updated Sucessfully..");
				resp.sendRedirect("reporter/index.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("reporter/index.jsp");
			}
			
			
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
	}

}



