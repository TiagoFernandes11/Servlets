<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Category management</title>
	</head>
	<body align="center">
	<div align="center">
		<jsp:directive.include file = "header.jsp" />
		
		<div align="center">
	 		<h2>Category Management</h2>
	 		<h3><a href="create_category">Create new category</a></h3>
	    </div>
	    <c:if test="${not empty deleted}">
	    	<div style="color:green">
	    		${deleted}
	    	</div>
	    </c:if>
	    <c:if test="${not empty notDeleted}">
	    	<div style="color:red">
	    		${notDeleted}
	    	</div>
	    </c:if>
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="category" items="${categories}" varStatus="status">
				<tr>
					<th>${status.index + 1}</th>
					<th>${category.categoryId}</th>
					<th>${category.name}</th>
					<th>
						<a href="update_category?id=${category.categoryId}">edit</a> 
						<a href="delete_category?id=${category.categoryId}" 
						onclick="return confirm('Are you sure you want to delete category: ${category.name} ?')">delete</a>
					</th>
				</tr>
			</c:forEach>
		</table>
		<jsp:directive.include file = "footer.jsp" />
		</div>
	</body>
</html>