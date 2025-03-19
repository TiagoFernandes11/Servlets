<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new user</title>
</head>
<body>
	<jsp:directive.include file = "header.jsp" />
	
	
	<div align="center">
		<c:if test="${not empty user.userId}">	
			<h2>Update user</h2>
		</c:if>
		<c:if test="${empty user.userId}">	
			<h2>Create user</h2>
		</c:if>		
		<c:if test="${not empty error}">
        	<div style="color: red; font-weight: bold;">
           		 Error: ${error}
       		 </div>
    	</c:if>
    	<c:if test="${not empty success}">
        	<div style="color: green;">
           		 Success: ${success}
       		 </div>
    	</c:if>
		<div align="center" style="width: fit-content">
	    	<c:if test="${empty user.userId}">
				<form style="display:flex; flex-direction:column; align-items: flex-end;" action="create_user" method="post" onsubmit="return validateInput()">
    		</c:if>
			<c:if test="${not empty user.userId}">
				<form style="display:flex; flex-direction:column; align-items: flex-end; " action="update_user?id=${user.userId}" method="post" onsubmit="return validateInput()">
				<div>
					ID: ${user.userId}
				</div>
			</c:if>	
			<div>
				<label for="fullName">Full name:</label>
				<input type="text" name="fullName" id="fullName" value="${user.fullName}">
			</div>
			<div>
				<label for="email">Email:</label>
				<input type="text" name="email" id="email" value="${user.email}">
			</div>
			<div>
				<label for="password">Password:</label>
				<input type="password" name="password" id="password" value="${user.password}">
			</div>
			<div>
				<input type="submit">
			</div>
			</form>
		</div>
	</div>
	
	
	<script>
	function validateInput() {
	    var fullName = document.getElementById('fullName').value.trim();
	    var email = document.getElementById('email').value.trim();
	    var password = document.getElementById('password').value.trim();
	    
	    if (fullName === '') {
	      alert('Full name is required!');
	      document.getElementById('fullName').focus();
	      return false;
	    }

	    if (email === '') {
	      alert('Email is required!');
	      document.getElementById('email').focus();
	      return false;
	    }

	    if (password === '') {
	      alert('Password is required!');
	      document.getElementById('password').focus();
	      return false;
	    }

	    return true;
	}

</script>
	<jsp:directive.include file = "footer.jsp" />
</body>
</html>