<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body>
	<% 
	if(session.getAttribute("errore")!=null && session.getAttribute("errore").toString()=="true")
	{
			session.setAttribute("errore", "false");
			out.println("<p><div class=\"errore\"><label for='Errore'> Errore nel Login </label></div></p>");
	}
	%>
		<form class="login" action="LoginServlet" method="post">

				<label for="user">Username: </label>
			
				<input 
					type="text" 
					id="user" 
					name="username" 
					placeholder="Inserisci username"
				>
					<!-- pattern="[A-Za-z\d]{6,12}"
					title="L'username deve avere una lunghezza tra i 6 e i 12 caratteri e contenere
						   solamente lettere e numeri" -->
		
				<label for="pass">Password: </label>
			
				 
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

	
</body>
</html>