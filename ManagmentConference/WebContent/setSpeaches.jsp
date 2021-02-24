<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="manegment.conference.classes.User, manegment.conference.classes.Speach, java.util.ArrayList"%>
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
ArrayList<Speach> speaches = (ArrayList<Speach>)request.getAttribute("speaches");
%>
<h1>
This is list of speaches from confernce: <c:out value="${conference}"></c:out>. You can remove and change name of it.
</h1>
<h5>
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
Begin: <%=speaches.get(i).getTime() %>
</td>
<td>
Interval: <%=speaches.get(i).getInterval() %> min.
</td>
<td>
<%=speaches.get(i).getLogin() %>
</td>
<td>
<input type="submit" value="Change name of this speach" name="<%= speaches.get(i).getNameSpeach() %>">
</td>
</tr>
<%
}%>
</table>
</form>
</h5>
<form action="jumptoaddspeach" method="get">
<input type="submit" value="Add new speach">
</form>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Back">
</form>
</body>
</html>