<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/vittoriostyle2.css" rel="stylesheet">
</head>
<body>
	<%@include file="/css/header.jsp"%>


	<div class="navbar">
		<a class="active" href="/home/index">Home</a> 
		<a href="/user/logout"	id="logout">Logout</a>
	</div>

	<div class="main">
		<h1>Benvenuto ${user.getUsername()}</h1>
		<div class="div-left">
			<form class="url" action="/user/analyze" method="post">
				<label for="URL"><h3>URL</h3></label> 
				<input type="text" id="url" name="linkUrl" placeholder="Inserisci url" pattern="https?://.+" title="L'indirizzo deve iniziare con https oppure con http" required>
				<button type="submit" value="Conferma" name="pulsante">Conferma</button>
				<button type="reset" value="Reset" name="pulsante">Reset</button>
			</form>

		</div>
		<div class="div-right">
			<table>
				<tr>
					<th class="intestazioneTabella" colspan="3">ULTIMI URL VISITATI</th>

				</tr>
				<tr>
					<th>#</th>
					<th>URL</th>
				</tr>


				<%
					/* List<URLDTO> listaCronologia = (List<URLDTO>) session.getAttribute("listaCronologia");
					if (listaCronologia != null) {
						for (int i = 0; i < listaCronologia.size() && i < 5; i++) {
							String link = listaCronologia.get(i).getURLname();
							out.println("<tr>");
							out.println("<th>" + (i + 1) + "</th>");
							out.println("<th> <a type=\"submit\" href=\"UrlServlet?mode=link&linkUrl=" + link + "\">" + link + "</a> </th>");
							out.println("</tr>");
						}
					}*/
	%>


			</table>
		</div>
	</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>
