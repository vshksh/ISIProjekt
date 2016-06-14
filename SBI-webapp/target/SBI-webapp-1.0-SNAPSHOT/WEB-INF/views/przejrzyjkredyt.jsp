
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Przejrzyj kredyt</title>
    </head>
    <body>
        <h1>Podaj id kredytu do przejrzenia</h1>
         <form:form method="GET" modelAttribute="formularzKr1">       
        <form:input type="text" path="iDkredytu" /><form:errors path="iDkredytu" />
            <input type="submit" value="Sprawdź kredyt" />
        </form:form>
    </body>
</html>
