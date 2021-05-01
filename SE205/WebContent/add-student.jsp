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

	<%-- TO-DO: CREATE A FORM FOR ADDING USER --%>
	<div class="row">
		<div class="container">

			<form action="insert" method="post">
				<h3 class="text-center">INSERT STUDENT</h3>
				
				<fieldset class="form-group">
					<label>Name</label> <input type="text" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text" class="form-control"
						name="address" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text" class="form-control"
						name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Phone Number</label> <input type="text" class="form-control"
						name="phoneNumber" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Class</label> <input type="text" class="form-control"
						name="sclass" required="required">
				</fieldset>

				<div class="col text-center">
					<button type="submit" class="btnAdd">ADD</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
