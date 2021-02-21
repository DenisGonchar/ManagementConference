<%@page import="manegment.conference.classes.Conference"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/newConf.jpg);
  }
</style>
</head>
<body>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
<form action="registrationconfservlet" method="get">
<input type="text" name="nameConf" placeholder="Name Conference" value="">
<br>
<input type="text" name="place" placeholder="Place"  value="">
<br>
<input type="date" name="date" placeholder="Date" value="">
<br>
<input type="time" name="time" placeholder="Time" value="">
<br>
<input type="submit" value="Add">
</form>
</body>
</html>