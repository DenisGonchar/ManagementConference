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
  body { background: url(img/speaker.png);
  }
   h1 {
    background: #b24fe0;
    color: white;
    padding: 1px;
   }
</style>
</head>
<body>
<h1>
Here you can change parameters of conferences.
</h1>
<%
Conference conference = (Conference)session.getAttribute("conference");
%>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
<form action="saveconferenceservlet" method="get">
<input type="text" name="nameConf" value=<%= conference.getNameConf() %>>
<br>
<input type="text" name="place" value="<%= conference.getPlace() %>">
<br>
<input type="text" name="date" value="<%= conference.getDate() %>">
<br>
<input type="text" name="time" value="<%= conference.getTime() %>">
<br>
<input type="submit" value="Save">
</form>
</body>
</html>