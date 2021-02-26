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
    .tableForm{
    background: #bdb4c2;
    color: black;
    padding: 1px;
   }
</style>
</head>
<body>
<h1>
This is list of speaches from confernce: <c:out value="${conference.nameConf}"></c:out>. You can remove and change name of it.
</h1>
<div class="tableForm">
<form action="deleditspeechservlet" method="get">
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
<input type="submit" value="Change parameters of this speach" name="ch<c:out value="${s.code}"></c:out>">
</td>
<td>
<input type="submit" value="delete" name="d<c:out value="${s.code}"></c:out>">
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptoaddspeach" method="get">
<input type="submit" value="Add new speach">
</form>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>