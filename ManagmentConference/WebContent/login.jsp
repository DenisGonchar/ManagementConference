<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/admin.jpg);
  }
   h1 {
    background: #433af0;
    color: white;
    padding: 2px;
   }
.gradient-button {
  text-decoration: none;
  display: inline-block;
  color: white;
  padding: 10px 15px;
  margin: 0px 0px;
  border-radius: 10px;
  font-family: 'Montserrat', sans-serif;
  text-transform: uppercase;
  letter-spacing: 2px;
  background-image: linear-gradient(to right, #9EEFE1 0%, #4830F0 51%, #9EEFE1 100%);
  background-size: 200% auto;
  box-shadow: 0 0 20px rgba(0, 0, 0, .1);
  transition: .5s;
}
.gradient-button:hover {
  background-position: right center;
}
form {
  text-align: center;
}
#mainForm{
	position: absolute;
	top: 150px;
	left: 370px;
}
</style>
</head>
<body>
<div id = "mainForm">
<form action="loginservlet" method="get">
<input type="text" name="login" placeholder="Input Your Login" />
<br>
<input type="password" name="pass" placeholder="Input Your Password" />
<br>
<input type="submit" class="gradient-button" value="       Login       "/>
<%
String error = (String) request.getAttribute("Error");
if(error != null){
	%>
	<b><%=error%></b>
	<%
}
%>
</form>
<form action= "jumptoregistration" method= "get">
<input type="submit" class="gradient-button" value=" Registration ">
</form>
</div>
</body>
</html>