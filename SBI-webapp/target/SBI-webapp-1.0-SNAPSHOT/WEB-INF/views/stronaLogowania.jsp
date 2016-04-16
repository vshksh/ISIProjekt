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
        <h1>Logowanie:</h1>
        
        <form:form method="POST" modelAttribute="formularzLog">   <!-- modelAttribute - klasa-->        
        <tr>
              <th>Adres email: </th>
              <td><form:input type="text" path="email" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="email" /></c:if></td>
	</tr>

         <tr>
              <th>Hasło</th>
              <td><form:input type="text" path="haslo" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="haslo" /></c:if></td>
	</tr>

        <input type="submit" value="Wyślij formularz" />
       </form:form>

        
    </body>
</html>

