<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">
<link href="css/alert.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body>
	<div class="alert-login"
	 	 style="display:${loginErrato?'block':'none'}">
	<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
	  
	  Attenzione! Dati errati!
	  
	</div>
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
			
				 
				 <input type="password" id="pass" name="password" placeholder="Inserisci password">
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

	
</body>
</html>