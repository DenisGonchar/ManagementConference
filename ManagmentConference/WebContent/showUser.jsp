<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="manegment.conference.classes.User, manegment.conference.classes.Conference, java.util.ArrayList"%>
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
    h5 {
    background: #bdb4c2;
    color: black;
    padding: 1px;
   }
</style>
</head>
<body>
<%
User user = (User)session.getAttribute("user");
ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
%>
<h1>
This is a list of users who signed up for this conference.
</h1>
<h5>
<form action="deleditconference" method="get">
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
|<%=users.get(i).getRolle()%>|
</td>
</tr>
<%
}%>
</h5>
</table>
</form>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>