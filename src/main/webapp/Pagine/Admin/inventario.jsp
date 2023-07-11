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

	  		<div class="search-bar">
			    <input type="text" id="search-input" placeholder="Cerca per titolo, artista, genere...">
			    <button id="search-button">Cerca</button>
			</div>

			<button id="add-album-button">Aggiungi Nuovo Album</button>

			<table id="inventory-table">
			    <thead>
			    	<tr>
				        <th>Copertina</th>		
				        <th onclick="sortTable(0)">Titolo</th>				        
				        <th onclick="sortTable(1)">Artista</th>
				        <th onclick="sortTable(2)">Genere</th>
				        <th onclick="sortTable(3)">Prezzo</th>
				        <th onclick="sortTable(4)">EAN</th>
				        <th onclick="sortTable(5)">Quantità</th>
			        </tr>
			    </thead>
			    <tbody>
			     	<tr>
			     		<td><img src="../../Album/Master of Puppets.jpg"></td> 
			     		<td><a href="record-road-pagina-impostazioni-prodotto.html">Master of Puppets</a></td>    	
			     		<td>Metallica</td>
			     		<td>Thrash Metal</td>
			     		<td>38.99&euro;</td>
			     		<td>0075678669637</td>
			     		<td>10</td>
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
