<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<link href="css/alert.css" rel="stylesheet">
</head>
<body>

<div class="alert"
	 style="display:${urlErrato?'block':'none'}">
	  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
	  
	  Attenzione! Indirizzo URL inesistente!
</div>

<div class="header">SEO Analyzer</div>



</body>
</html>