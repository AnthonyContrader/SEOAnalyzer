
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for Admin ">
<meta name="author" content="Vittorio Valent">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>

<body>
	<%@include file="css/header.jsp"%>


	<div class="navbar">
		<a class="active" href="/homeadmin.jsp">Home</a> 
		<a href=/admin/getall>Users</a>
		<a href="/admin/logout" id="logout">Logout</a>
	</div>

	<div class="main">
		<h1>Welcome ${user.getUsername()}</h1>

		<h2>INSERIRE QUI TUTTE LE STATISTICHE DELL'ADMIN!</h2>
		<h3>Numero di utenti registrati = ${session.getAttribute("numeroUtenti")}</h3>
		<h3>Numero di utenti ADMIN registrati = ${session.getAttribute("numeroUtentiAdmin")}</h3>
		<h3>Numero di utenti USER registrati = ${session.getAttribute("numeroUtentiUser") }</h3>


	</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>