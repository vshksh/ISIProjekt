
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brak dostępu do rachunku</title>
    </head>
    <body>
        <h1>Nie masz dostępu do rachunku!</h1>
       <form:form method="POST" modelAttribute="formularzZly">
            <input type="submit" name="action" value="Strona glowna" />
            <input type="submit" name="action" value="zmiana danych" />
        </form:form>
    </body>
</html>
