<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Analisi URL</title>
</head>
<body>

<%@include file="css/header.jsp"%>


	<div class="navbar">
		<a class="active" href="homeuser.jsp">Home</a> 
		<a class="" href="">TODO</a>
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>
	
	<div class="main">
		<h1>Il tuo sito: ${url}</h1>
		<form class="url" action="UrlSceltaServlet" method="post">
			<button type="submit" name="scelta" value="parole"> Conta parole</button>
			<button type="submit" name="scelta" value="immagini"> Conta immagini</button>
			<button type="submit" name="scelta" value="link"> Conta Links</button>
			<button type="submit" name="scelta" value="parola"> Cerca una parola</button>
			<button type="submit" name="scelta" value="ottimizza"> Consigli di ottimizzazione </button>
			
		</form>

	</div>
	
	<div>
	<% 
	if(request.getAttribute("numLink")!=null){
			String s = request.getAttribute("numLink").toString();
	out.println("<p> Il numero di link presenti nella pagina è: " + s + "</p>");}%>
	</div>
	
<%@ include file="css/footer.jsp"%>
</body>
</html>