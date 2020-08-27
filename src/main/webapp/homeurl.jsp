
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
	<%@include file="css/header.jsp" 
	import="java.util.List"
	import="it.contrader.dto.UserDTO"%>


	<div class="navbar">
		<a class="active" href="/homeuser.jsp">Home</a> 
		<a href="/user/logout"	id="logout">Logout</a>
	</div>
		<%
			//metto la sessione con i vari dati in request
			request.getSession();
		//numero immagini
				//conta parole
			/*if (request.getAttribute("numeroParole") != null) {
				String nParole = request.getAttribute("numeroParole").toString();
				String argomento = request.getAttribute("argomento").toString();
				List<Word> list = (List<Word>) request.getAttribute("listaParole");
				out.println("<table>");
				out.println("<tr><th>#</th><th>PAROLA</th><th>OCCORRENZA</th></tr>");
				for (int i=0; i<list.size() && i < 10 ; i++){
					out.println("<tr>");
					out.println("<th>" + (i + 1) + "</th>");
					out.println("<th>" + list.get(i).getWord() + "</th>");
					out.println("<th>" + list.get(i).getCount() + "</th>");
					out.println("</tr>");
				}
					
// 				out.println("<p> Il numero di parole presenti nella pagina è: " + nParole + "</p>");
// 				out.println("L'argomento rilevato è: " + argomento);
				out.println("<tr><td></td><td></td><td></td></tr>");
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
			} */
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

			
		%>
		<div class="main">
		
		</div>

	</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>