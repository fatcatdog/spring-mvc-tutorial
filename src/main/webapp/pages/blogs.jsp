<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Blogs?</title>
<body>
	<h2>Blogs</h2>
	
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${blog != null}">
			<h3>List of Blogs</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Author ID</th>
						<th>Blog Title</th>
						<th>Blog Body</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="blog" items="${blog}">
						<tr>
							<td>${blog.id}</td>
							<td>${blog.authorId}</td>
							<td>${blog.title}</td>
							<td>${blog.body}</td>
							<%-- <td><a
								href="<%=request.getContextPath()%>/update/user/${user.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/user/${user.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a>
								<a
								href="<%=request.getContextPath()%>/user/${user.id}">View</a></td> --%>
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
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>