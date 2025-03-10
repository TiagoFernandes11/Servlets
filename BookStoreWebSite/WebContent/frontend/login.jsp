<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:directive.include file = "header.jsp" />
	<form>
		<label for="login">Email: </label>
		<input type="text" name="login" id="login"/>
		<label for="password">Password: </label>
		<input type="password" name="password" id="password"/>
		<input type="submit" value="Submit">
	</form>
	<jsp:directive.include file = "footer.jsp" />
</body>
</html>