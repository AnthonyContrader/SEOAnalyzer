
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for User">
<meta name="author" content="Vittorio Valent">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<title>Home</title>

<!-- Bootstrap core CSS   

	System.out.println("Numero parole = " + <%=session.getAttribute("numeroParole")%>); 
		System.out.println("Numero immagini = " + <%=session.getAttribute("numImg")%>);
		System.out.println("Numero link = " + <%=session.getAttribute("numLink")%>);
-->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle2.css" rel="stylesheet">
</head>

<body>
	<%@include file="css/header.jsp"%>


	<div class="navbar">
		<a class="active" href="/home/index">Home</a> 
		<a href="/user/logout"	id="logout">Logout</a>
	</div>
	
	<div class="container">
		<div id="title1">GRAFICO STATISTICHE PER IL SITO <%=((String)session.getAttribute("linkurl")).toUpperCase()%> </div>
		<canvas id="urlChart"></canvas>
	</div>
	
	<script>
		let urlChart = document.getElementById('urlChart').getContext('2d');
		
		Chart.defaults.global.defaultFontFamily = 'cursive';
		Chart.defaults.global.defaultFontSize = 18;
		Chart.defaults.global.defaultFontColor = 'black';
		
		
	
		
		
		let url = new Chart(urlChart, {
			type: 'bar', //bar, pie, horizontalBar, line, doughnut, radar, polarArea
			data:{
				labels:['Parole totali', 'Immagini totali', 'Link totali'],
				datasets:[{
					label: 'Numero',
					data:[
						<%=session.getAttribute("numeroParole")%>,
						<%=session.getAttribute("numImg")%>,
						<%=session.getAttribute("numLink")%>
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
	</script>

	<%@ include file="css/footer.jsp"%>

</body>
</html>