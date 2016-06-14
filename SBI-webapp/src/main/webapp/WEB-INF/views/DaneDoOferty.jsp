
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta</title>
    </head>
    <body>
        Możemy Ci zaproponować kredyt na następujących warunkach <br>
        kwota: ${formularzOf.kwota} <br>
        okres: ${formularzOf.okres} <br>
        prowizja: ${formularzOf.prowizja} <br>
        oprocentowanie: ${formularzOf.oprocentowanie}%   <br>
        
        <form:form method="POST" modelAttribute="formularzOf">
            <input type="submit" name="action" value="Strona glowna" />
            <input type="submit" name="action" value="zmiana danych" />
            <input type="submit" name="action" value="Wez kredyt" />
        </form:form>
        
    </body>
</html>