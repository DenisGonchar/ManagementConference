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
Это список участников конференции - <c:out value="${conference.nameConf}"></c:out>.
</h1>
<div class="tableForm">
<form action="deleditconference" method="get">
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
|<c:out value="${u.rolle}"></c:out>|
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Назад">
</form>
</body>
</html>