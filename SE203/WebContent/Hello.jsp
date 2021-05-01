<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
<style>
form {
	width: fit-content;
	text-align: center;
	margin-top: 30px;
}
</style>
</head>
<body>
	<form action="Hello" method="post">
		<fieldset>
			Enter your name: <input type="text" name="name" size="20"> <br>
			<br> Enter your password: <input type="password" name="password" size="20"> <br> 
			<br> <input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>