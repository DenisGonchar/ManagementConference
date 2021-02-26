<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/admin.jpg);
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
Привет, <c:out value="${user.login}"></c:out>, Вы, модератор.
</h1>
<form action="" method="get">
<input type="submit" value="English/Russian">
</form>
<br>
<br>
<div class="tableForm">
Это список гостей. Вы можете удалить их из конференции.
<form action="deluserservlet" method="get">
<table>
<c:forEach items="${users}" var="u">
<tr>
<td>
<c:out value="${u.login}"></c:out>
</td>
<td>
<c:out value="${u.email}"></c:out>
</td>
<td>
<input type="submit" value="Удалить" name="<c:out value="${u.login}"></c:out>">
</td>
<td>
<input type="submit" value="Сделать спикером" name="gts<c:out value="${u.login}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
<div class="tableForm">
Это список спикеров. Вы можете удалить их из конференции.
<form action="deluserservlet" method="get">
<table>
<c:forEach items="${speakers}" var="s">
<tr>
<td>
<c:out value="${s.login}"></c:out>
</td>
<td>
<c:out value="${s.email}"></c:out>
</td>
<td>
<input type="submit" value="Удалить" name="<c:out value="${s.login}"></c:out>">
<input type="submit" value="Сделать гостем" name="gtu<c:out value="${s.login}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
<div class="tableForm">
Это список мероприятий. Вы можете удалить или изменить их.
<form action="deleditconference" method="get">
<table>
<c:forEach items="${conferences}" var="c">
<tr>
<td>
<c:out value="${c.nameConf}"></c:out>
</td>
<td>
<c:out value="${c.place}"></c:out>
</td>
<td>
<c:out value="${c.date}"></c:out>
</td>
<td>
<c:out value="${c.time}"></c:out>
</td>
<td>
<input type="submit" value="Удалить" name="d<c:out value="${c.code}"></c:out>">
</td>
<td>
<input type="submit" value="Изменить" name="e<c:out value="${c.code}"></c:out>">
</td>
<td>
<input type="submit" value="Показать участников" name="s<c:out value="${c.code}"></c:out>">
</td>
<td>
<input type="submit" value="Настройка докладов" name="set<c:out value="${c.code}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptoregconfservlet" method="get">
<input type="submit" value="Добавить новую конференцию">
</form>
<form action="jumptologinpageservlet" method="get">
<input type="submit" value="Назад">
</form>
</body>
</html>