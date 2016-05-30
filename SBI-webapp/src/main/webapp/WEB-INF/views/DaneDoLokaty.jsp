<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lokaty</title>
    </head>
    <body>
        <form:form method="POST" modelAttribute="formularzLokaty">  
            Podaj ile chcesz wpłacić na lokatę
        <td><form:input type="number" path="kwota" /><form:errors path="kwota" /></td><br>
            Wybierz interesującą cię lokatę <br>
            lokata 1.5% na 6 miesięcy 
            <input type="submit" name="action" value="6 miesiecy" /> <br>
            lokata 2% na 6 miesięcy 
            <input type="submit" name="action" value="rok" /> <br>
            lokata 2.5% na 6 miesięcy 
            <input type="submit" name="action" value="2 lata" /> <br>
            <input type="submit" name="action" value="Strona glowna" />
        </form:form>
        
    </body>
</html>
