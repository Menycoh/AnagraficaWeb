<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Si è verificato un Errore</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
	color: #333;
}

.container {
	background-color: #fff;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	text-align: center;
	width: 80%;
	max-width: 500px;
}

h1 {
	color: #dc3545; /* Rosso per l'errore */
	margin-bottom: 20px;
}

p {
	font-size: 1.1em;
	margin-bottom: 25px;
}

a {
	display: inline-block;
	background-color: #007bff;
	color: white;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	transition: background-color 0.3s ease;
}

a:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1><%=request.getParameter("msg") != null ? request.getParameter("msg") : "Si è verificato un errore!"%></h1>
		<p>L'operazione non è andata a buon fine.</p>
		<p>Per maggiori dettagli, controlla i log del server (console di
			Eclipse o file `catalina.out`).</p>
		<p>
			<a href="<%=request.getContextPath()%>/index.jsp">Torna alla
				pagina iniziale</a>
		</p>
	</div>
</body>
</html>