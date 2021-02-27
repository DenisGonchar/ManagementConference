<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/speaker.png);
  }
   h1 {
    background: #b24fe0;
    color: white;
    padding: 1px;
   }
    .tableForm{
    background: #bdb4c2;
    color: black;
    padding: 1px;
   }
</style>
</head>
<body>
<h1>
Это список докладов из конференции под названием: <c:out value="${conference.nameConf}"></c:out>. Вы можете удалить или изменить название доклада.
</h1>
<div class="tableForm">
<form action="deleditconference" method="get">
<table>
<c:forEach items="${speaches}" var="s">
<tr>
<td>
"<c:out value="${s.nameSpeach}"></c:out>"
</td>
<td>
Begin: <c:out value="${s.time}"></c:out>
</td>
<td>
Interval: <c:out value="${s.interval}"></c:out> min.
</td>
<td>
|login: <c:out value="${s.login}"></c:out>|
</td>
<td>
<input type="submit" value="Изменить параметры доклада" name="ch<c:out value="${s.code}"></c:out>">
</td>
<td>
<input type="submit" value="Удалить" name="d<c:out value="${s.code}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptoaddspeach" method="get">
<input type="submit" value="Добавить новый доклад">
</form>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Назад">
</form>
</body>
</html>