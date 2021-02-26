<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="changeparametersspeechservlet" method="get">
<input type="text" placeholder="Name of Speach" value='<c:out value="${speach.nameSpeach}"></c:out>' name = "nameSpeach">
<input type="text" placeholder="Time of Speach" value='<c:out value="${speach.time}"></c:out>' name = "time">
<input type="text" placeholder="Interval of Speach" value='<c:out value="${speach.interval}"></c:out>' name = "interval">
<input type="text" placeholder="Speaker of Speach" value='<c:out value="${speach.login}"></c:out>' name = "login">
<input type="submit" value="Change">
</form>
</body>
</html>