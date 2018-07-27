<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>Super exciting User page</title>

<body>
	<h2>View user</h2>
	Id : ${userDetails.id}
	<br /> First Name : ${userDetails.firstName}
	<br /> Last Name : ${userDetails.lastName}
	<br /> Email : ${userDetails.email}
	<br /> DOB : ${userDetails.dob}
	<p><a href="<%=request.getContextPath()%>/users">Users</a>
								&nbsp;</p>
</body>
</html>