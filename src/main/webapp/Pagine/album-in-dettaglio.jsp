<%@ page import="com.progetto.viniliprogetto.Model.Vinile" %>
<%@ page import="com.progetto.viniliprogetto.Controller.CarrelloServlet" %>
<%
  Vinile vinile = (Vinile) request.getAttribute("vinile");
%>
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

  <link rel="stylesheet" href="http://localhost:8080/ViniliProgetto_war_exploded/styledettaglio.css"/>

  <style>
    .nav-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<section class="container">
  <div class="random-albums my-3" class="row">
    <div class="col-12 row my-5 my-sm-4 mx-auto">
      <div class="album">
        <div class="col-12 col-sm-3">
          <img src="img/Cover/${vinile.copertina}" alt="Copertina Album" class="img-fluid">
        </div>
      </div>
      <div class="information col-8 col-sm-6 mt-4 mt-sm-0">
        <h3 class="display-6"><strong>${vinile.titolo}</strong></h3>
        <p>Titolo</p>
        <h3>${vinile.autore}</h3>
        <p>Artista</p>
        <h5>${vinile.getGenereString()}</h5>
        <p>Genere</p>
        <h5>${vinile.annoPubblicazione}</h5>
        <p>Anno</p>
        <h5>${vinile.ean}</h5>
        <p>EAN</p>
      </div>
      <div class="prezzo col-4 col-sm-3 mt-4 mt-sm-0">
        <h3 class="display-3"><strong>${vinile.prezzo}&euro;</strong></h3>
        <p>Prezzo</p>
        <!-- <button class="add-to-cart btn btn btn-warning">Aggiungi al carrello</button> -->

        <c:if test="${utente != null}">
          <c:if test="${!utente.admin && vinile.numeroDisponibili > 0}">
            <form method="post" action="<%=request.getContextPath()%>/cliente/carrello">
              <button type="submit" id="add-to-cart-button" name="action"
                      value="<%= CarrelloServlet.AGGIUNGI_VINILE %>">Aggiungi al carrello
              </button>
              <input type="hidden" name="ean" value="${vinile.ean}"/>
            </form>
            <p>${vinile.numeroDisponibili} copie disponibili</p>
          </c:if>
          <c:if test="${!utente.admin && vinile.numeroDisponibili == 0}">
            <p>Prodotto NON disponibile all'acquisto.<br>Copie esaurite.</p>
          </c:if>
          <c:if test="${utente.admin}">
            <button id="go-to-modify-album-button">Modifica prodotto</button>
            <p>${vinile.numeroDisponibili} copie disponibili</p>
          </c:if>
        </c:if>
        <c:if test="${utente == null}">
          <c:if test="${vinile.numeroDisponibili > 0}">
            <p>${vinile.numeroDisponibili} copie disponibili.<br><a href="login">Accedere</a> al proprio profilo se si vuole acquistare.</p>
          </c:if>
          <c:if test="${vinile.numeroDisponibili == 0}">
            <p>Prodotto NON disponibile all'acquisto.<br>Copie esaurite.</p>
          </c:if>
        </c:if>

      </div>
    </div>
  </div>
</section>


<%@ include file="footer.jsp" %>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>