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
    .tableForm {
    background: #bdb4c2;
    color: black;
    padding: 1px;
   }
</style>
</head>
<body>
<h1>
Hello <c:out value="${user.login}"></c:out>, you are speaker.
</h1>
<div class="tableForm">
Это список ваших докладов. Выможете удалить или изменить их тему.
<form action="speachservlet" method="get">
<table>
<c:forEach items="${speaches}" var="s">
<tr>
<td>
<c:out value="${s.nameSpeach}"></c:out>
</td>
<td>
Begin: <c:out value="${s.time}"></c:out>
</td>
<td>
Interval: <c:out value="${s.interval}"></c:out> min.
</td>
<td>
<c:out value="${s.login}"></c:out>
</td>
<td>
<input type="submit" value="Именить" name="e<c:out value="${s.code}"></c:out>">
</td>
<td>
<input type="submit" value="Удалить" name="d<c:out value="${s.code}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
<div class="tableForm">
Это список всех конференций. Вы можете принять в них участие.
<form action="regspeakerbyconference" method="get">
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
<input type="submit" value="Зарегистрироваться" name="<c:out value="${pc.conference.code}"></c:out>">
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