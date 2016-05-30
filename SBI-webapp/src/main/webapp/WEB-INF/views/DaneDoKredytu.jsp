<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularz pobierania kredytu</title>
    </head>
    <body>
        <h1>Prosimy o podanie danych potrzebnych do zaoferowania odpowiedniego kredytu</h1>
         <strong>${message}</strong>
        
        <form:form method="POST" modelAttribute="formularzKr">       
               <table>
        <tr>
        <th>  
        Informacje o kredycie
        </th>
        </tr>
        <tr>
              <th>Kwota kredytu</th>
              <td><form:input type="number" path="kwota" /><form:errors path="kwota" /></td>
	</tr>
        
        <tr>
              <th>Okres</th>
              <td><form:input type="number" path="okres" /><form:errors path="okres" /></td> 
	</tr>
        <tr>
        <th> 
        </th>
        </tr>
        <tr>
        <th>   
         Informacje o kliencie
        </th>
        </tr>
        <tr>
              <th>stan cywilny</th>
              <td><form:select path="stancywilny">
                   <form:option value="kawaler">Kawaler/panna</form:option>  
                    <form:option value="wdowa">wdowiec/wdowa</form:option>  
                    <form:option value="rozwod">rozwiedziony/rozwiedziona</form:option>  
                    <form:option value="malzenstwo">w związku małżeńskim</form:option> 
                    <form:option value="separacja">w separacji</form:option> 
                </form:select>
               <form:errors path="stancywilny" /></td>
	</tr>
        <tr>
              <th>wyksztalcenie</th>
              <td><form:select path="wyksztalcenie" >
                    <form:option value="podstawowe">podstawowe/gimnazjum</form:option>  
                    <form:option value="zawodowe">zawodowe</form:option>  
                    <form:option value="srednie">średnie</form:option>  
                    <form:option value="inz">wyższe 1.stopnia</form:option> 
                    <form:option value="mgr">wyższe 2.stopnia</form:option> 
                    <form:option value="dr">wyższe 3.stopnia</form:option> 
                 </form:select>
               <form:errors path="wyksztalcenie" /></td>
	</tr>  
         <tr>
              <th>status mieszkaniowy</th>
              <td><form:select path="statusmieszkaniowy" >
                    <form:option value="wlasne">własnościowe</form:option>  
                    <form:option value="wynajem">wynajmowanie</form:option>  
                    <form:option value="sluzbowe">służbowe</form:option>  
                    <form:option value="rodzina">zamieszkiwanie u rodziny</form:option> 
                    <form:option value="inne">inne</form:option> 
                 </form:select>
                  <form:errors path="statusmieszkaniowy" /></td>
	</tr>
        <tr>
              <th>forma zatrudnienia</th>
              <td><form:select path="formazatrudnienia" >
                  <form:option value="praca">umowa o pracę</form:option>  
                    <form:option value="zlecenie">umowa o zlecenie</form:option>  
                    <form:option value="renta">renta</form:option>  
                    <form:option value="prezes">prezesi i członkowie zarządu</form:option> 
                    <form:option value="emerytura">emerytura</form:option> 
                    <form:option value="radny">radni</form:option> 
                    <form:option value="posel">posłowie</form:option> 
                    <form:option value="wojsko">kontrakt wojskowy</form:option> 
                    <form:option value="menager">kontrakt menedżerski</form:option> 
                 </form:select>
              <form:errors path="formazatrudnienia" /></td>
	</tr>  
        <tr>
              <th>Ilość osób w gospodarstwie domowym</th>
              <td><form:input type="number" path="ile_w_domu" /><form:errors path="ile_w_domu" /></td>
	</tr>
        
        <tr>
              <th>Łączny dochód gospodarstwa domowego</th>
              <td><form:input type="number" path="lacznydochod" /><form:errors path="lacznydochod" /></td> 
	</tr>
         

              </table>

        <input type="submit" name="action" value="Sprawdz dostepny kredyt" />
       </form:form>

        
    </body>
</html>
