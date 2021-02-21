<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="manegment.conference.classes.User, manegment.conference.classes.Conference, java.util.ArrayList"%>
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
%>
<h1>
Hello <%=user.getLogin() %>, you are user.
</h1>
<%
ArrayList<Conference> conferences = (ArrayList<Conference>)request.getAttribute("conferences");
ArrayList<Boolean> regconf = (ArrayList<Boolean>)request.getAttribute("regconf");
%>
<br>
<h5>
This is list of conferences. You can register for one of them.
<form action="reguserbyconference" method="get">
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
<%
if(!regconf.get(i)){
%>
<input type="submit" value="Registration" name="<%= conferences.get(i).getCode() %>">
<%
} 
%>
</td>
</tr>
<%
}%>
</table>
</form>
</h5>
<form action="jumptologinpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>