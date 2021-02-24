<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
Adding new speach to conference: <c:out value="${conference.nameConf}"></c:out>.
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
<form action="addnewspeachservlet" method="get">
<input type="text" name="nameSpeach" placeholder="Input name of Speach" />
<br>
<input type="time" name="time" placeholder="Time" />
<br>
<input type="text" name="interval" placeholder="How long" />
<br>
<input type="submit" value="Save"/>
</form>
</div>
</body>
</html>