<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new user</title>
</head>
<body>
	<jsp:directive.include file = "header.jsp" />
	
	
	<div align="center">
		<h2>Create new user</h2>
		<c:if test="${not empty error}">
        	<div style="color: red; font-weight: bold;">
           		 ${error}
       		 </div>
    	</c:if>
    	<c:if test="${not empty success}">
        	<div style="color: green;">
           		 ${success}
       		 </div>
    	</c:if>
		<form action="create_user" method="post" onsubmit="return validateInput()">
			<label for="fullName">Full name:</label>
			<input type="text" name="fullName" id="fullName">
			<label for="email">Email:</label>
			<input type="text" name="email" id="email">
			<label for="password">Password:</label>
			<input type="password" name="password" id="password">
			<input type="submit">
		</form>
	</div>
	
	
	<script>
  function validateInput() {
    // Obtém os valores dos campos do formulário
    var fullName = document.getElementById('fullName').value.trim();
    var email = document.getElementById('email').value.trim();
    var password = document.getElementById('password').value.trim();
    
    // Verifica se o campo de 'fullName' está vazio
    if (fullName === '') {
      alert('Full name is required!');
      document.getElementById('fullName').focus(); // Foca no campo
      return false; // Impede o envio do formulário
    }

    // Verifica se o campo de 'email' está vazio
    if (email === '') {
      alert('Email is required!');
      document.getElementById('email').focus(); // Foca no campo
      return false; // Impede o envio do formulário
    }

    // Verifica se o campo de 'password' está vazio
    if (password === '') {
      alert('Password is required!');
      document.getElementById('password').focus(); // Foca no campo
      return false; // Impede o envio do formulário
    }

    // Se todos os campos estiverem preenchidos, permite o envio
    return true;
  }
</script>
	<jsp:directive.include file = "footer.jsp" />
</body>
</html>