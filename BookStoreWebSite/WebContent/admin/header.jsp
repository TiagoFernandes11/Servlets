<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header" align="center">
	<div id="logo">
		<h1>Logo</h1>
	</div>
	<div>
		Welcome, <c:out value="${sessionScope.useremail}"/> &nbsp | &nbsp <a href="logout">Logout</a>
		<br>
		<br>
	</div>
	<div>
		<b>
			<a href="list_users">Users</a> &nbsp | &nbsp
			<a href="list_categories">Categories</a> &nbsp | &nbsp
			<a href="list_books">Books</a> &nbsp | &nbsp
			<a href="list_customers">Customers</a> &nbsp | &nbsp
			<a href="list_reviews">Reviews</a> &nbsp | &nbsp
			<a href="list_orders">Orders</a>
		</b>
	</div>
</div>