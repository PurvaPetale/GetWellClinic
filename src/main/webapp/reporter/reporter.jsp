<%@page import="com.entity.Doctor"%>
<%@page import="com.dbo.DoctorDbo"%>
<%@page import="com.entity.reporter"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dbo.SpecialistDbo"%>
<%@page import="com.dbo.ReporterDbo" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leaves details</title>

<%@include file="../component/all_css.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container-fluid p-3">
		<div class="row">

		


			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Leaves Details</p>
						
						<c:if test="${not empty errorMsg}">
							<p class="fs-5 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-5 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Doctor name</th>
									<th scope="col">Leave start date</th>
									<th scope="col">Leave end date</th>
									<th scope="col">Status</th>
									
								</tr>
							</thead>
							<tbody>

								<%
								ReporterDbo dbo3 = new ReporterDbo(DBConnect.getConn());
								List<reporter> list3 = dbo3.getAllDetails();
								for (reporter d : list3) {
								%>
								<tr>
									<td><%=d.getDoctname()%></td>
									<td><%=d.getLeavesd() %></td>
									<td><%=d.getLeaveed()%></td>
									<td><%=d.getStatus()%></td>
									
									<td>
									
										<a href="edit_doctor.jsp?id=<%=d.getId()%>" class="btn btn-sm btn-primary">Edit</a>
										<a href="../deleteDoctor?id=<%=d.getId()%>" class="btn btn-sm btn-danger">Delete</a>
									
									</td>
								</tr>

								<%
								}
								%>
								<%-- <td><a href="edit_doctor.jsp?id=<%=d.getId()%>"%> --%>
							</tbody>

						</table>

					</div>
				</div>
			</div>
			
		</div>
	</div>
			
</body>
</html>