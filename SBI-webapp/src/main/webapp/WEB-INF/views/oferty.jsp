<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Bankowość internetowa</title>
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
            <a class="navbar-brand" href="#">Logo</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="#">Klienci indywidualni</a></li>
              <li><a href="#">Bankowość internetowa</a></li>
              <li><a href="#">Biznes</a></li>
              <li><a href="#">Przedsiębiorstwa</a></li>
              <li><a href="#">O banku</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#">
              	<select name="chooseLang">
                    <option value="1"><img src="image/en.png" alt="logo" /></option>
                    <option value="2"><img src="image/en.png" alt="logo" /></option>
              	</select>
              </a></li>
              <li><a href="#">Kontakt</a></li>
            </ul>
          </div>
        </div>
      </nav>

      <div class="panel">
      	<nav class="navbar navbar-default">
        <div class="panel-body">
          <div class="navbar-header">
          </div>
          <div id="navbar" class="navbar-collapse collapse">
                    <c:forEach begin="0" end="${ileofert-1}" var="i">
                        <c:set var="nazwa" scope="session" value="nazwa${i}"/>
                        <c:set var="typ" scope="session" value="typ{i}"/>
                        <c:set var="limity" scope="session" value="limity{i}"/>
                        <c:set var="procent" scope="session" value="procent{i}"/>
                        Nazwa oferty ${i+1}: ${nazwa} <br>
                        typ ${i+1}: ${typ}<br>
                        limity ${i+1}: ${limity}<br>
                        procent ${i+1}: ${procent}<br>
                    </c:forEach>

            </ul>
              
          </div>
        </div>
      </nav>
      </div>
    </div>
</body>
</html>
