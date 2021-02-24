<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#Error{
	color: red;
}
</style>
</head>
<body>
<form action="registrationservlet" method= "get">
<input type="text" name="login" placeholder="Input Your Login" />
<br>
<input type="password" name="pass" placeholder="Input Your Password" />
<br>
<input type="email" name="email" placeholder="Input Your email" />
<br>
<input type="submit" value="LOGIN"/>
<div id = "Error">
<c:out value="${Error}"></c:out>
</div>
</form>
</body>
</html>