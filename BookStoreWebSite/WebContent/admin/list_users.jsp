<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list_users</title>
</head>
<body>
	 <jsp:directive.include file = "header.jsp" />
	 
	 <div align="center">
	 	<h2>Users Management</h2>
	 	<h3><a href="create_user">Create new user</a></h3>
	 </div>

	 
	 <div align="center">
	 	<c:if test="${not empty deletedUserId}">
	 		<div style="color: green;">
           		User with id:${deletedUserId} deleted
        	</div>
	 	</c:if>	 
	 	<c:if test="${not empty notDeletedUserId}">
	 		<div style="color: red;">
           		Could not find user with ID: ${notDeletedUserId}, or it might have been deleted by another admin.
        	</div>
	 	</c:if>	 
	 	<table border="1" cellpadding="5">
  			<tr>
  				<th>Index</th>
    			<th>ID</th>
    			<th>Email</th>
    			<th>Full Name</th>
    			<th>Actions</th>
  			</tr>
  			<c:forEach var="user" items="${users}" varStatus="status" >
  			<tr>
  				<td>${status.index + 1}</td>
    			<td>${user.userId}</td>
    			<td>${user.email}</td>
    			<td>${user.fullName}</td>
    			<td>
    				<a href="update_user?id=${user.userId}">edit</a> 
    				<a href="delete_user?id=${user.userId}" 
    				   onclick="return confirm('Are you sure you want to delete user id: ${user.userId} ?')">delete</a>
    			</td>
  			</tr>
			</c:forEach>
		</table>
	 </div>
	 
	 <jsp:directive.include file = "footer.jsp" />
</body>
</html>