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
		<a class="active" href="UrlServlet?mode=home">Home</a> <a
			href="LogoutServlet" id="logout">Logout</a>
	</div>
	<div class="main">
		<h1>Il tuo sito: ${url}</h1>
		<div class="div-left">
			<form class="url" action="UrlSceltaServlet" method="post">
				<button type="submit" name="scelta" value="parole">Conta
					parole</button>
				<button type="submit" name="scelta" value="immagini">Conta
					immagini</button>
				<button type="submit" name="scelta" value="link">Conta
					Links</button>
				<button type="submit" name="scelta" value="parola">Cerca
					una parola</button>
				<button type="submit" name="scelta" value="ottimizza">
					Consigli di ottimizzazione</button>
			</form>
		</div>

		<div class="div-right">
			<%
				//conta parole
			if (request.getAttribute("numeroParole") != null) {
				String nParole = request.getAttribute("numeroParole").toString();
				String argomento = request.getAttribute("argomento").toString();
				List<String> list = (List<String>) request.getAttribute("listaParole");
				for (String s : list)
					out.println(s + "<br>");
// 				out.println("<p> Il numero di parole presenti nella pagina è: " + nParole + "</p>");
// 				out.println("L'argomento rilevato è: " + argomento);
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>Numero di parole</th>");
				out.println("<td>" + nParole + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Argomento</th>");
				out.println("<td>" + argomento + "</td>");
				out.println("</tr>");
				out.println("</table>");
				request.setAttribute("numeroParole", null);
				request.setAttribute("argomento", null);
				request.setAttribute("listaParole", null);
			}
			// conta link
			if (request.getAttribute("numLink") != null) {
				String s = request.getAttribute("numLink").toString();
				//out.println("<p> Il numero di link presenti nella pagina è: " + s + "</p>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>Numero di link</th>");
				out.println("<td>" + s + "</td>");
				out.println("</tr>");			
				out.println("</table>");
				request.setAttribute("numLink", null);
			}
			//conta immagini
			if (request.getAttribute("numImg") != null) {
				String s = request.getAttribute("numImg").toString();
				//out.println("<p> Il numero di immagini presenti nella pagina è: " + s + "</p>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>Numero di immagini</th>");
				out.println("<td>" + s + "</td>");
				out.println("</tr>");			
				out.println("</table>");
				request.setAttribute("numImg", null);
			}
			//ottimizza
			if (request.getAttribute("percentualeFrasiMeno25Parole") != null) {
				double temp = (double) request.getAttribute("percentualeFrasiMeno25Parole");
				out.println("<p> La percentuale di frasi con meno di 25 parole nella pagina è: " + temp + "% </p>");
				temp = (double) request.getAttribute("percentualeFrasiMeno8Parole");
				out.println("<p> La percentuale di frasi con meno di 8 parole nella pagina è: " + temp + "% </p>");
				temp = (double) request.getAttribute("percentualeParagrafiMeno150Parole");
				out.println("<p> La percentuale di paragrafi con meno di 150 parole nella pagina è: " + temp + "% </p>");
				request.setAttribute("percentualeFrasiMeno25Parol", null);
				request.setAttribute("percentualeFrasiMeno8Parole", null);
				request.setAttribute("percentualeParagrafiMeno150Parole", null);
			}

			if (request.getAttribute("parolaTest") != null) {
				out.println("<div class=\"parola\">");
				out.println("<h1>Inserisci la parola da cercare: </h1>");
				out.println("<form class=\"cerca\" action=\"UrlSceltaServlet?test=yes\" method=\"post\">");
				out.println(
				"<input type=\"text\" id=\"cercaparola\" name=\"cercaparola\" placeholder=\"Inserisci parola\"required>");
				out.println("<button type=\"submit\" name=\"scelta\" value=\"parola\"> Cerca parola</button>");
				out.println("</form>");
				out.println("</div>");

				if (request.getAttribute("trovata") != null) {
					out.println("<p>La parola " + request.getAttribute("cerca").toString() + " è stata trovata: "
					+ request.getAttribute("trovata").toString() + " volte!</p>");
				}
			}
			%>
		</div>
	</div>
	<%@ include file="css/footer.jsp"%>
</body>
</html>