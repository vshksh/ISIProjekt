<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<style>
h1   {color:blue; font-size:100%;}
h2   {color:blue; font-size:100%;}
li    {color:green;font-size:150%}
</style>
<body>
	<h1>${title}</h1>
	<h1>${message}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>Jestes zalogowany jako : ${pageContext.request.userPrincipal.name} 
                 | <a href="<c:url value="/logout" />" > Logout</a></h2>  
	</c:if>

					<a href="<c:url value="/zalogowano" />">
					Moje konto
					</a>
            <ul>
				<li>
					Numer rachunku: ${nrRachunku}
				</li>
				<li>
					Saldo: ${saldo}
				</li>

            </ul>
</body>
</html>