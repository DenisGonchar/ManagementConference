<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style type="text/css">
   body { background: url(img/speaker.png);
  }
    .tableForm{
    background: #bdb4c2;
    color: black;
    padding: 1px;
   }
 </style>
</head>
<body>
<div class="tableForm">
Добавление доклада в конференцию: <c:out value="${conference.nameConf}"></c:out>.
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Назад">
</form>
<form action="addnewspeachservlet" method="get">
<input type="text" name="nameSpeach" placeholder="Название доклада" />
<br>
<input type="time" name="time" placeholder="Время" />
<br>
<input type="text" name="interval" placeholder="Интервал" />
<br>
<input type="submit" value="Сохранить"/>
</form>
</div>
</body>
</html>