<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="changeparametersspeechservlet" method="get">
<input type="text" placeholder="Тема доклада" value='<c:out value="${speach.nameSpeach}"></c:out>' name = "nameSpeach">
<input type="text" placeholder="Время доклада" value='<c:out value="${speach.time}"></c:out>' name = "time">
<input type="text" placeholder="Интервал" value='<c:out value="${speach.interval}"></c:out>' name = "interval">
<input type="text" placeholder="Имя спикера" value='<c:out value="${speach.login}"></c:out>' name = "login">
<input type="submit" value="Изменить">
</form>
</body>
</html>