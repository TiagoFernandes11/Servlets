<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create new category</title>
	</head>
	<body align="center">
	<div align="center">
		<jsp:directive.include file = "header.jsp" />
		
		<c:if test="${empty category}">
			<div align="center">
	 			<h2>Create new category</h2>
	    	</div>
		</c:if>
		
		<c:if test="${not empty category}">
			<div align="center">
	 			<h2>Update category</h2>
	    	</div>
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
    	
    	<c:if test="${empty category}">
			<form action="create_category" method="post">
    	</c:if>
    	
    	<c:if test="${not empty category}">
			<form action="update_category?id=${category.categoryId}" method="post">
    	</c:if>
    	
    		<div>Category ID: ${category.categoryId}</div>
			<label for="category_name">Name: </label>
			<input id="category_name" type="text" name="name"/>
			<input type="submit" value="Submit">
		</form>
		
		<jsp:directive.include file = "footer.jsp" />
		</div>
	</body>
</html>