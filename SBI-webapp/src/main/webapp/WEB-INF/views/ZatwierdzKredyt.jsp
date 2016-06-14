<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularz zatwierdzania kredytu</title>
    </head>
    <body>
        
        <form:form method="POST" modelAttribute="formularzKr">   
            <th>Podaj id kredytu który chcesz zatwierdzić/odrzucić</th>
              <td><form:input type="number" path="id" /><form:errors path="id" /></td>

        <input type="submit" name="action" value="Zatwierdz" />
        <input type="submit" name="action" value="Odrzuc" />
       </form:form>

        
    </body>
</html>