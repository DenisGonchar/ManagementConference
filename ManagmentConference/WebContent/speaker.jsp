<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
This is list of yours speaches. You can remove and change name of it.
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
<input type="submit" value="edit" name="<c:out value="${s.nameSpeach}"></c:out>">
</td>
<td>
<input type="submit" value="delete" name="<c:out value="${s.nameSpeach}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
<div class="tableForm">
This is list of conferences. You can register for one of them.
<form action="regspeakerbyconference" method="get">
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
<c:if test="${regConf == false}">
<input type="submit" value="Registration" name="<c:out value="${c.code}"></c:out>">
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptologinpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>