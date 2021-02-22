<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="manegment.conference.classes.User, manegment.conference.classes.Speach, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Speach> speaches = (ArrayList<Speach>)request.getAttribute("speaches");
%>
This is list of yours speaches. You can remove and change name of it.
<form action="deleditconference" method="get">
<table>

<%
for(int i=0; i<speaches.size(); i++){
%>
<tr>
<td>
"<%=speaches.get(i).getNameSpeach() %>"
</td>
<td>
<%=speaches.get(i).getTime() %>
</td>
<td>
<%=speaches.get(i).getInterval() %>
</td>
<td>
<%=speaches.get(i).getLogin() %>
</td>
<%
}%>
</table>
</form>
</body>
</html>