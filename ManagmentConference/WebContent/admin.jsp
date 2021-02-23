<%@page import="manegment.conference.classes.Speach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="manegment.conference.classes.User, manegment.conference.classes.Speach, manegment.conference.classes.Conference, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/admin.jpg);
  }
   h1 {
    background: #b24fe0;
    color: white;
    padding: 2px;
   }
   h4 {
    background: #bdb4c2;
    color: black;
    padding: 2px;
   }
   h5 {
    background: #bdb4c2;
    color: black;
    padding: 2px;
   }
</style>
</head>
<body>
<%
User user = (User)session.getAttribute("user");
ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
%>
<h1>
Hello <%=user.getLogin() %>, you are moderator.
</h1>
<form action="" method="get">
<input type="submit" value="English/Russian">
</form>
<br>
<br>
<h4>
This is list of Users. You can remove them from conferences.
<form action="deluserservlet" method="get">
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
<td>
<input type="submit" value="Go to Speaker" name="gts<%= users.get(i).getLogin() %>">
</td>
</tr>
<%
}%>
</table>
</form>
</h4>

<%
User speaker = (User)session.getAttribute("speaker");
ArrayList<User> speakers = (ArrayList<User>)request.getAttribute("speakers");
%>
<br>
<h4>
This is list of Speakers. You can remove them from conferences.
<form action="deluserservlet" method="get">
<table>
<%
for(int i=0; i<speakers.size(); i++){
%>
<tr>
<td>
<%=speakers.get(i).getLogin() %>
</td>
<td>
<%=speakers.get(i).getEmail() %>
</td>
<td>
<input type="submit" value="delete" name="<%= speakers.get(i).getLogin() %>">
<input type="submit" value="Propose speach" name="<%= speakers.get(i).getLogin() %>">
<input type="submit" value="Go to User" name="gtu<%= speakers.get(i).getLogin() %>">
</td>
</tr>
<%
}%>
</table>
</form>
</h4>
<%
Conference conference = (Conference)session.getAttribute("conference");
ArrayList<Conference> conferences = (ArrayList<Conference>)request.getAttribute("conferences");
%>
<br>
<h5>
This is list of conferences. You can remove and change it.
<form action="deleditconference" method="get">
<table>
<%
for(int i=0; i<conferences.size(); i++){
%>
<tr>
<td>
<%=conferences.get(i).getNameConf() %>
</td>
<td>
<%=conferences.get(i).getPlace() %>
</td>
<td>
<%=conferences.get(i).getDate() %>
</td>
<td>
<%=conferences.get(i).getTime() %>
</td>
<td>
<input type="submit" value="Delete" name="d<%= conferences.get(i).getCode() %>">
</td>
<td>
<input type="submit" value="Edit" name="e<%= conferences.get(i).getCode() %>">
</td>
<td>
<input type="submit" value="Show Users" name="s<%= conferences.get(i).getCode() %>">
</td>
<td>
<input type="submit" value="Settings speaches" name="set<%= conferences.get(i).getCode() %>">
</td>
</tr>
<%
}%>
</table>
</form>
</h5>
<form action="jumptoregconfservlet" method="get">
<input type="submit" value="Add New Conference">
</form>
<form action="jumptologinpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>