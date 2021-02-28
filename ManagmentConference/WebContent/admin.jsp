<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
Hello <c:out value="${user.login}"></c:out>, you are moderator.
</h1>
<br>
<br>
<div class="tableForm">
This is list of Users. You can remove them from conferences.
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
<input type="submit" value="delete" name="<c:out value="${u.login}"></c:out>">
</td>
<td>
<input type="submit" value="Make Him a Speaker" name="gts<c:out value="${u.login}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
<div class="tableForm">
This is list of Speakers. You can remove them from conferences.
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
<input type="submit" value="delete" name="<c:out value="${s.login}"></c:out>">
<input type="submit" value="Make Him a User" name="gtu<c:out value="${s.login}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
<div class="tableForm">
This is list of conferences. You can remove and change it.
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
<input type="submit" value="Delete" name="d<c:out value="${c.code}"></c:out>">
</td>
<td>
<input type="submit" value="Edit" name="e<c:out value="${c.code}"></c:out>">
</td>
<td>
<input type="submit" value="Show Users" name="s<c:out value="${c.code}"></c:out>">
</td>
<td>
<input type="submit" value="Settings speaches" name="set<c:out value="${c.code}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptoregconfservlet" method="get">
<input type="submit" value="Add New Conference">
</form>
<form action="jumptologinpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>