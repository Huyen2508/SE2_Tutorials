<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- Include the JSTL Core library in JSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br>
		<br> 
		<ul>
		<li><a href="/SE204/student">Student List</a></li>
		<li><a href="/SE204/course">Course List</a></li> 
		<li><a href="/SE204/enrolments">Enrolment List</a></li>
		</ul><br> 
		<br>
		<h3 class="text-center">COURSE LIST</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Semester</th>
					<th>Teacher</th>
				</tr>
			</thead>
			<tbody>
				<%-- c:forEach => basic iteration tag --%>
				<c:forEach var="course" items="${listCourse}">
					<tr>
						<%-- c:out => for expressions --%>
						<td><c:out value="${course.idCourse}" /></td>
						<td><c:out value="${course.name}" /></td>
						<td><c:out value="${course.semester}" /></td>
						<td><c:out value="${course.teacher}" /></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>