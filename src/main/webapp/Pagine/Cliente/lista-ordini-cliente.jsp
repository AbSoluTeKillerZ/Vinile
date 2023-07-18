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

<div class="container my-4">
    <div class="row">
        <div class="col-md-6">
            <div class="input-group mb-3">
                <input type="text" id="search-input" class="form-control"
                       placeholder="Cerca per destinatario, numero ordine...">
                <button id="search-button" class="btn btn-primary" type="button">Cerca</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <table class="table table-striped">
        <thead>
			<tr>
				<th onclick="sortTable(0)">Numero ordine</th>
				<th onclick="sortTable(1)">Destinatario</th>
				<th onclick="sortTable(3)">Data Acquisto</th>
				<th onclick="sortTable(4)">Totale</th>
				<th onclick="sortTable(5)">Stato</th>
			</tr>
        </thead>
        <tbody>
			<c:forEach items="${ordini}" var="ordine">
				<tr>
					<td><a href="ordine-in-dettaglio.jsp">${ordine.numero-ordine}</a></td>
					<td>${ordine.destinatario}</td>
					<td>${ordine.data-acquisto}</td>
					<td>${ordine.totale-acquisto}&euro;</td>
					<td>${ordine.stato}</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
</div>



<%@ include file = "../footer.jsp" %>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
