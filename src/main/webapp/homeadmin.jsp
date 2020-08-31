
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for Admin ">
<meta name="author" content="Vittorio Valent">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/vittoriostyle2.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<title>Home</title>
</head>

<body>
	<%@include file="css/header.jsp"%>


	<div class="navbar">
		<!--  <a class="active" href="/homeadmin.jsp">Home</a> -->
		<a href=/home/index>Home</a>
		<a href=/admin/getall>Users</a>
		<a href="/admin/logout" id="logout">Logout</a>
	</div>

	<div class="main">
		<h1>Welcome ${user.getUsername()}</h1>

		

		<!-- <h3></h3> -->
		<!--  <h4>Numero di utenti registrati = </h4> -->
		<!--  <h4>Numero di utenti ADMIN registrati =</h4> -->
		<!--  <h4>Numero di utenti USER registrati =</h4> --> 

		<div class="container">
			<div id="title1">GRAFICO STATISTICHE UTENTI</div>
			<canvas id="userChart"></canvas>
			<div id="title2">GRAFICO STATISTICHE SITI WEB</div>
			<canvas id="dataChart"></canvas>
		</div>
		
	</div>

	<script>
		let userChart = document.getElementById('userChart').getContext('2d');
		let dataChart = document.getElementById('dataChart').getContext('2d');
		
		Chart.defaults.global.defaultFontFamily = 'cursive';
		Chart.defaults.global.defaultFontSize = 18;
		Chart.defaults.global.defaultFontColor = 'black';
		
		let users = new Chart(userChart, {
			type: 'bar', //bar, pie, horizontalBar, line, doughnut, radar, polarArea
			data:{
				labels:['Utenti totali', 'Utenti Admin', 'Utenti User'],
				datasets:[{
					label: 'Numero',
					data:[
						<%=session.getAttribute("numeroUtenti")%>,
						<%=session.getAttribute("numeroUtentiAdmin")%>,
						<%=session.getAttribute("numeroUtentiUser")%>
					],
					backgroundColor:[
						'#00A990',
						'#2A8EFF',
						'#2AFF8E'
					],
					borderWidth:1,
					borderColor:'black',
					hoverBorderWidth:3,
					hoverBorderColor:'black'
					
				}]
			},
			options:{
				legend:{
					position:'right',
				},
				layout:{
					padding:{
						left:30,
						right:30,
						bottom:30,
						top:30
					}
				}
			}
				
		});
		
		let statistics = new Chart(dataChart, {
			type: 'doughnut', //bar, pie, horizontalBar, line, doughnut, radar, polarArea
			data:{
				labels:['Immagini', 'Link', 'Parole', 'Parole ricercate', 'Url'],
				datasets:[{
					label: 'Numero',
					data:[
						<%=session.getAttribute("numeroImmagini")%>,
						<%=session.getAttribute("numeroLink")%>,
						<%=session.getAttribute("numeroParole")%>,
						<%=session.getAttribute("numeroRicercaParole")%>,
						<%=session.getAttribute("numeroUrl")%>
					],
					backgroundColor:[
						'#00A990',
						'#2A8EFF',
						'#2AFF8E',
						'#F0C300',
						
					],
					borderWidth:1,
					borderColor:'black',
					hoverBorderWidth:3,
					hoverBorderColor:'black'
				}]
			},
			options:{
				legend:{
					position:'right',
				},
				layout:{
					padding:{
						left:30,
						right:30,
						bottom:30,
						top:30
					}
				}
			}
				
		});
		
	</script>
	<%@ include file="css/footer.jsp"%>

</body>
</html>