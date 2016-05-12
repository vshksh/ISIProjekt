
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rejestracja</title>
    </head>
    <body>
        <h1>Prosimy się zarejestrować:</h1>
        <strong>${message}</strong>
        
        <form:form method="POST" modelAttribute="formularzRej">   <!-- modelAttribute - klasa, którą wysłał kontroler-->
                                    <!-- Pola form:input odpowiadają polom tej klasy -->
                <table>
         
        <tr>
              <th>Imię</th>
              <td><form:input type="text" path="imiona" /><form:errors path="imiona" /></td>
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
        
        
        
        
        
        

        <input type="submit" value="Wyślij formularz" />
       </form:form>

        
    </body>
</html>
