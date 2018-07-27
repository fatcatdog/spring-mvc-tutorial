<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Update a user boo yah</title>

<body>
	<h2>Update our User</h2>
	
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update User</h3>
	<form method="POST" name="update_user"
		action="<%=request.getContextPath()%>/update/user">
		<input hidden="hidden" name="id" value="${id}" type="text" /> First
		Name: <input name="fname" value="${userDetails.firstName}" type="text" />
		<br />
		<br /> Last Name: <input name="lname" value="${userDetails.lastName}"
			type="text" /> <br /> <br /> Email: <input name="email"
			value="${userDetails.email}" type="text" /><br />
		<br /> DOB: <input name="dob" value="${userDetails.dob}" type="text" /><br />
		<br /> <input value="Update User" type="submit" />
	</form>
<p><a href="<%=request.getContextPath()%>/users">Users</a>
&nbsp;</p>
<p><a href="<%=request.getContextPath()%>/">Home</a>
&nbsp;</p>
<p><a href="<%=request.getContextPath()%>/blogs">Blogs</a>
&nbsp;</p>
</body>
</html>