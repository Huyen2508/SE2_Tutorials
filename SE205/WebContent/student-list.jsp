<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>STUDENT MANAGEMENT</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<br>

	<div class="row">
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
					<c:forEach var="s" items="${listStudent}">

						<tr>
							<td><c:out value="${s.id}" /></td>
							<td><c:out value="${s.name}" /></td>
							<td><c:out value="${s.address}" /></td>
							<td><c:out value="${s.email }" /></td>
							<td><c:out value="${s.phoneNumber}" /></td>
							<td><c:out value="${s.sclass}" /></td>
							<td><a href="edit?id=<c:out value='${s.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${s.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
