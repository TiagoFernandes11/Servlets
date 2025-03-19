<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login admin</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>  
		<div align="center">
			<h2>Book Store Administration</h2>
			<h3>Admin login</h3>
			<div style="width: fit-content">
				<form style="display:flex; flex-direction:column; align-items: flex-end;" onsubmit="validate(event)">
					<div>
						<label for="email">E-mail</label>
						<input type="text" id="email" name="email">
					</div>
					<div>
						<label for="password">Password</label>
						<input type="password" id="password" name="password">
					</div>
					<input type="submit" value="login">
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp" %>  
		<script>
			function validate(event){
				let email = document.getElementById("email").value.trim();
				let password = document.getElementById("password").value.trim();
				
				if(email === ''){
					alert("Email is required!");
					document.getElementById("email").focus();
					event.preventDefault();
					return;
				}
				
				if(password === ''){
					alert("Password is required!");
					document.getElementById("password").focus();
					event.preventDefault();
					return;
				}
			}
		</script>
	<</html>