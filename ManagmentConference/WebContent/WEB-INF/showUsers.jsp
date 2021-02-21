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
This is list of Users. You can remove them from conferences.
<form action="" method="get">
<table>
<%
for(int i=0; i<users.size(); i++){
%>
<tr>
<td>
<%=users.get(i).getLogin() %>
</td>
<td>
<%=users.get(i).getEmail() %>
</td>
<td>
<input type="submit" value="delete" name="<%= users.get(i).getLogin() %>">
</td>
</tr>
<%
}%>
</table>
</form>
</body>
</html>