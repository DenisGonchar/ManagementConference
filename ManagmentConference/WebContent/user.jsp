<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
Hello, <c:out value="${user.login}"></c:out>, you are user.
</h1>
<br>
<div class="tableForm">
This is list of conferences. You can register for one of them.
<form action="reguserbyconference" method="get">
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