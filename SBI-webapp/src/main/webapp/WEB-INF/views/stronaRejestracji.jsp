
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

       <form:form method="POST" modelAttribute="formularzRej">   <!-- modelAttribute - klasa, którą wysłał kontroler-->
                                    <!-- Pola form:input odpowiadają polom tej klasy -->
                <table>
        <tr>
              <th>Twój login</th>
              <td><form:input type="text" path="login" /><form:errors path="login" /></td>
	</tr>
        
        <tr>
              <th>Hasło:</th>
              <td><form:input type="text" path="haslo" /><form:errors path="haslo" /></td>
	</tr>
        
        <tr>
              <th>Nazwisko</th>
              <td><form:input type="text" path="nazwisko" /><form:errors path="nazwisko" /></td>
	</tr>
        <tr>
              <th>PESEL</th>
              <td><form:input type="text" path="pesel" /><form:errors path="pesel" /></td>
	</tr>
        <tr>
              <th>Adres email:</th>
              <td><form:input type="text" path="adresEmail" /><form:errors path="adresEmail" /></td>
	</tr>   
       
        <tr>
              <th>Adres korespondencji:</th>
              <td><form:input type="text" path="adresKorespondencji" /><form:errors path="adresKorespondencji" /></td>
	</tr>        
        <tr>
              <th>Kod pocztowy:</th>
              <td><form:input type="text" path="kodPocztowy" /><form:errors path="kodPocztowy" /></td>
	</tr>        
        <tr>
              <th>Telefon:</th>
              <td><form:input type="text" path="telefon" /><form:errors path="telefon" /></td>
	</tr>        

              </table>
        
        
        
        
        
          <div class="form-group"> 
                  <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" input type="submit" class="btn btn-default">Zarejestruj</button>
                  </div>
          </div>

      
              </form:form>
              
              
              
          </div>
        </div>
      </nav>
      </div>
    </div>
</body>
</html>