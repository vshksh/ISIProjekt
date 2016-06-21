 <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Bankowość Internetowa</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"  aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Bankowość internetowa</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="#">O banku</a></li>
              <li><a href="<c:url value="/oferty" />">Nasze oferty</a></li>
              <li><a href="<c:url value="/rejestracja" />">Rejestracja</a></li>
              <li><a href="<c:url value="/login" />">Logowanie</a></li>

          </div>
        </div>
      </nav>

      <div class="panel">


        <h1 style="text-align: center;">iBankowość</h1>
        <hr />
        <p>

            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            Nasz bank oferuje kompleksowe usługi bankowe, przejrzysty i intuicyjny interfejs, oraz wszystkie
            możliwości płynące z korzystania z naszej bankowości internetowej. Ponadto jesteśmy bankiem, który
            dba o swoich klientów i zawsze najszybciej oraz najsprawniej służy pomocą. Zapewniamy naszym 
            klientom profesjonalizm, bezpieczeństwo, niezawodność i anonimowość. Jesteśmy prężnie rozwijającym 
            się bankiem, który ceni wygode klienta ponad wszystko. 
        </p>
        <hr style="clear: both;" />
      </div>

    </div>
</body>
</html>