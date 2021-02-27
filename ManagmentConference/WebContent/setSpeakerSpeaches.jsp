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
Speaker, <c:out value="${user.login}"></c:out>, edits speech - <c:out value="${speach.nameSpeach}"></c:out>.
</h1>
<div class="tableForm">
<form action="changetopikspeach" method="get">
<input type="text" placeholder="Topic of Speach" value='<c:out value="${speach.nameSpeach}"></c:out>' name = "topic">
<input type="submit" value="Change">
</form>
</div>
</body>
</html>