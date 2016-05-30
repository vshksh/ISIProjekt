<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zmiana danych użytkowników</title>
    </head>
    <body>

        <form:form method="POST" modelAttribute="formularzZmianyDanych">  
     
                <table>
         
        <tr>
              <th>Podaj pesel użytkownika którego dane chcesz zmienić</th>
              <td><form:input type="text" path="nazwa" /><form:errors path="nazwa" /></td>
	</tr>
        
        <tr>
              <th>Podaj co chcesz zmienić</th>
              <td><form:select path="co_zmienic">
                     <form:option value="plec">płeć (M/F)</form:option>     
                     <form:option value="imiona">imię</form:option>  
                    <form:option value="nazwisko">nazwisko</form:option>  
                    <form:option value="telefon">numer telefonu</form:option>  
                    <form:option value="adresEmail">adres email</form:option>  
                    <form:option value="adresKorespondencji">adres do korespondencji</form:option> 
                    <form:option value="kodPocztowy">kod pocztowy</form:option>  
            <!--        <form:option value="dataUrodzenia">date urodzenia (yyyy-MM-dd)</form:option>  nie działa dla daty, nie wiem czemu, baza danych robi i robi aż wyskakuje timeout -->
                </form:select>
               <form:errors path="co_zmienic" /></td>
	</tr>
        <tr>
              <th>Podaj nową wartość zmienianej</th>
              <td><form:input type="text" path="nowa_wartosc" /><form:errors path="nowa_wartosc" /></td>
	</tr>
              </table>
        
        <input type="submit" value="Aktualizuj konto" />
       </form:form>
    </body>
</html>
