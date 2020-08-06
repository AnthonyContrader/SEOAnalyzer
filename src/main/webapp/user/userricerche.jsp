<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO" import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Ricerche Utenti</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="UserServlet?mode=userlist">Users</a>
  <a href="UserServlet?mode=ricerche">Ricerche utenti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">


<table>
	<tr> 
		<th>ID utente</th>
		<th>Username</th>
		<th>URL</th>
	</tr>
	<% 
	int i = 0;
	List<String> l = (List<String>)request.getAttribute("ricerche");
	//System.out.println(request.getAttribute("ricerche").toString());
	for(String s: l)
		{
		String[] temp = s.split(",");
		out.println("<tr>");
		out.println("<td>" + temp[0] + "</td>");
		out.println("<td>" + temp[1] + "</td>");
		out.println("<td>" + temp[2] + "</td>");
		out.println("</tr>");
		}
	%>
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>