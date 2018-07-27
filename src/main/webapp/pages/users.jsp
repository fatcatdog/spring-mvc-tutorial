<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Our Users?</title>
<body>
	<h2>Our Users</h2>
	
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${userDetails != null}">
			<h3>List of Users</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>DOB</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userDetails}">
						<tr>
							<td>${user.id}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<td>${user.dob}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/user/${user.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/user/${user.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a>
								<a
								href="<%=request.getContextPath()%>/user/${user.id}">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				<p><a href="<%=request.getContextPath()%>/users">Users</a>
								&nbsp;</p>
				<p><a href="<%=request.getContextPath()%>/addUser">Add User</a>
				&nbsp;</p>
				<p><a href="<%=request.getContextPath()%>/">Home</a>
				&nbsp;</p>
				<p><a href="<%=request.getContextPath()%>/blogs">Blogs</a>
				&nbsp;</p>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>