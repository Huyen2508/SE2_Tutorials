<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- Include the JSTL Core library in JSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Student Management</title>
</head>
<body>
<jsp:include page="nav-bar.jsp"></jsp:include>
	<br>
	<div class="container">
		<h3 class="text-center">STUDENT LIST</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Class</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<%-- c:forEach => basic iteration tag --%>
				<c:forEach var="student" items="${listStudent}">
					<tr>
						<%-- c:out => for expressions --%>
						<td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.address}" /></td>
						<td><c:out value="${student.email}" /></td>
						<td><c:out value="${student.phoneNumber}" /></td>
						<td><c:out value="${student.sclass}" /></td>
						<td><a href="Sedit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="/SE204/student/insert" class="btn btn-primary">ADD STUDENT</a>
	</div>


</body>
</html>
