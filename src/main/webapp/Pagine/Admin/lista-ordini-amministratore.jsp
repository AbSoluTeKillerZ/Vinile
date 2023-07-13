<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap Demo</title>
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		  rel="stylesheet"
		  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<style>
		.nav-link:hover {
			text-decoration: underline;
		}
	</style>
</head>
<body>
		<%@ include file = "../header.jsp" %>

	  		<form action="#" method="GET" class="search-bar">	  			
			    <input type="text" id="search-input" placeholder="Cerca per ordine, cliente...">
			    <button id="search-button">Cerca</button>
			</form>

			<table id="order-table">
			    <thead>
			    	<tr>
				        <th onclick="sortTable(0)">Numero ordine</th>
				        <th onclick="sortTable(1)">Acquirente</th>
				        <th onclick="sortTable(2)">Data acquisto</th>
				        <th onclick="sortTable(3)">Totale</th>
				        <th>Stato</th>
			        </tr>
			    </thead>
			    <tbody>
			     	<tr>
			     		<td><a href="record-road-pagina-lista ordini-amministratore-dettaglio.html"></a># XX XXX XXXX</td>
			     		<td>Luca Verdi</td>
			     		<td>XXXX XX XX</td>
			     		<td>60.50&euro;</td>
			     		<td>Ordinato</td>
			     	</tr>
			    </tbody>
		    </table>

		    <script src="script.js"></script>

		<%@ include file = "../footer.jsp" %>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>
</body>

	</html>