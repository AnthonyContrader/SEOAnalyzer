<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
	<%@include file="css/header.jsp"%>


	<div class="navbar">
		<a class="active" href="homeuser.jsp">Home</a> 
		<a class="" href="">TODO</a>
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>

	<div class="main">
		<h1>Welcome ${user.getUsername()}</h1>
		<form class="url" action="UrlServlet?mode=insertUrl" method="post">

			<label for="URL">URL</label> 
			<input type="text" id="url" name="linkUrl" placeholder="Inserisci url"> 

			<button type="submit" value="Conferma" name="pulsante">Conferma</button>
			<button type="reset" value="Reset" name="pulsante">Reset</button>
		</form>

	</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>