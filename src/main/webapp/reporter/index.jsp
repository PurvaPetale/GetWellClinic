<%@page import="com.db.DBConnect" %>
<%@page import="java.sql.Connection" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="../component/all_css.jsp"%>
</head>
<body>

	<%@include file="navbar.jsp"%>
	
	<%Connection conn = DBConnect.getConn(); 
     // out.println(conn);
	%>
	
	<div id="carouselExampleControls" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="../img/hos1.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
			<div class="carousel-item">
				<img src="../img/hos2.png" class="d-block w-100" alt="..."
					height="650px">
			</div>
			<div class="carousel-item">
				<img src="../img/hos3.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>



	<%@include file="../component/footer.jsp"%>

	<c:if test="${not empty succMsg}">
		<p class=" text-center text-success fs-5">${succMsg}</p>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty errorMsg}">
		<p class="text-center text-danger fs-5">${errorMsg}</p>
		<c:remove var="errorMsg" scope="session" />
	</c:if>


</body>
</html>