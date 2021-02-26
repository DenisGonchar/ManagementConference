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
Speaker, <c:out value="${user.login}"></c:out>, edition speech - <c:out value="${speach.nameSpeach}"></c:out>.
<form action="changetopikspeach" method="get">
<input type="text" placeholder="Название доклада" value='<c:out value="${speach.nameSpeach}"></c:out>' name = "topic">
<input type="submit" value="Изменить">
</form>
</body>
</html>