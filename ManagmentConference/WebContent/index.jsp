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
  padding: 20px 30px;
  margin: 10px 20px;
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
.tableForm{
color: white;
}
</style>
</head>
<body>
<h1>
Welcome to our conference!
<br>
Press here for enter.
</h1>
<form action="jumptologin" method="get"> 
<div class="tableForm">
Russian
<input type="radio" name="language" value="ru">
English
<input type="radio" name="language" value="en" checked="checked">
</div>
<input type="submit" class="gradient-button" value="Start Conference!"/>
</form>
</body>
</html>