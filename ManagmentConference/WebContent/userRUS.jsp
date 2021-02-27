<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/user.jpg);
  }
   h1 {
    background: #b24fe0;
    color: white;
    padding: 2px;
   }
    .tableForm {
    background: #bdb4c2;
    color: black;
    padding: 2px;
   }

</style>
</head>
<body>
<h1>
Привет, <c:out value="${user.login}"></c:out>, Вы, гость.
</h1>
<br>
<div class="tableForm">
Это список всех конференций. Вы можете принять в них участие.
<form action="reguserbyconference" method="get">
<table>
<c:forEach items="${propConferences}" var="pc">
<tr>
<td>
<c:out value="${pc.conference.nameConf}"></c:out>
</td>
<td>
<c:out value="${pc.conference.place}"></c:out>
</td>
<td>
<c:out value="${pc.conference.date}"></c:out>
</td>
<td>
<c:out value="${pc.conference.time}"></c:out>
</td>
<td>
<c:if test="${pc.registration == false}">
<input type="submit" value="Зарегистрироваться" name="r<c:out value="${pc.conference.code}"></c:out>">
</c:if>
<c:if test="${pc.registration == true}">
<input type="submit" value="Выйти" name="u<c:out value="${pc.conference.code}"></c:out>">
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptologinpageservlet" method="get">
<input type="submit" value="Назад">
</form>
</body>
</html>