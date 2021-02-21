<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="manegment.conference.classes.User, manegment.conference.classes.Conference, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
User user = (User)session.getAttribute("user");
ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
%>
This is list of Users. You can change their parameters.
<form action="fromusertospeakerservlet" method="get">
<input type="text" name="login" value=<%= user.getLogin() %>>
<br>
<input type="text" name="email" value="<%= user.getEmail() %>">
<br>
<input type="text" name="rolle" value="<%= user.getRolle() %>">
<br>
<input type="submit" value="Save">
</form>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>