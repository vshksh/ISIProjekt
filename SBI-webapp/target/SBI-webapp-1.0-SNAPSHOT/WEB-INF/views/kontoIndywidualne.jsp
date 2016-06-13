<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Bankowość Internetowa</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="js/buttons.js"></script>
  <link rel="stylesheet" href="css/style.css">
</head>
<body onload="strona()">

<div class="container">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Logo</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="#">Klienci indywidualni</a></li>
          <li><a href="#">Bankowość prywatna</a></li>
          <li><a href="#">Biznes</a></li>
          <li><a href="#">Przedsiębiorstwa</a></li>
          <li><a href="#">O banku</a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>
<div class="container">
<nav class="navbar navbar-default">
	<div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-left">
        	<li><a id="odbiorcy" href="#" onclick="odb()"></a></li>
        	<li><a id="wiad" href="#" onclick="wiad()"></a></li>
        	<li><a id="zlecenia" href="#" ></a></li>
        	<li><a id="oferty" href="#" ></a></li>
        	<li><a id="prof" href="#" ></a></li>
        	<li><a type="button" class="btn btn-warning navbar-btn" href="<c:url value="/logout" />">   Wyloguj  </a></li>
        </ul>
		<div id="rozsz" style="clear:both">
		</div>
    </div>
</nav>
	<div class="col-md-12">
		<div class="col-md-4">
			<div class="loginUser">
				<span>Zalogowany jako:</span>
				${pageContext.request.userPrincipal.name}
				<br />
				<br />
				<br />
				
				<br />
				<br />
				<br />
			</div>
		</div>
		<div class="col-md-8">
		<!--<p class="bg-info" align="center">Zobacz nasze nowe oferty</p>
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp -->
			<div class="account" style="width:170px; height:180px; display: inline-block;">
				<a href="<c:url value="/przelew"/>"><img src="image/icon4.jpg"></a>
				<br />
				<span class="text-center">Przelewy</span>
			</div>
			&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			<div class="assignment" style="width:170px; height:180px; display: inline-block;">
				<a href="<c:url value="/rachunki" />"><img src="image/icon4.jpg"></a>
				<br />
				<span class="text-center">Rachunki</span>
			</div>
			&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			<div class="assignment" style="width:170px; height:180px; display: inline-block;">
				<a href="<c:url value="/lokaty" />"><img src="image/icon4.jpg"></a>
				<br />
				<span class="text-center">Lokaty</span>
			</div>

			
			&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
			<div class="cards" style="width:170px; height:180px; display: inline-block;">
				<a href="<c:url value="/mojekarty" />"><img src="image/icon4.jpg"></a>
				<br />
				<span class="text-center">Twoje karty</span>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>

