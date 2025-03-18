<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div id="header" align="center">
	<div id="logo">
		<h1>logo</h1>
	</div>
	<div id="seach">
		<input id="inputSearch" type="text" value="keyword"/>
		<input id="buttonSearch" type="button" value="Search">
		<a href="login">Sign in</a>
		|
		<a href="register">Register</a>
		|
		<a href="view_cart">Cart</a>
	</div>
	<div>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<a href="view_category?id=${category.categoryId}"><b>${category.name} </b></a>
			<c:if test="${listCategory.size() > status.index + 1}">&nbsp | &nbsp</c:if>
		</c:forEach>
	</div>
</div>
