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

        <form:form method="POST" modelAttribute="formularzZmianyStanu">  
     
                <table>
         
        <tr>
              <th>Podaj nazwę użytkownika którego dane chcesz zmienić</th>
              <td><form:input type="text" path="nazwa" /><form:errors path="nazwa" /></td>
	</tr>
        
        <tr>
              <th>Podaj co chcesz zmienić</th>
              <td><form:select path="co_zmienic">
             <!--         <form:option value="nazwa_konta">nazwę konta</form:option>     nazwa konta i pesel to klucze-->
             <!--       <form:option value="PESEL">pesel</form:option>  -->
                    <form:option value="stanKonta">stan konta</form:option>  
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
