      
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

            <!DOCTYPE html>
            <html lang="pl">

            <head>
                <title>Moje lokaty</title>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

                <style>
                    ul {
                        list-style-type: none;
                    }
                    
                </style>
            </head>

            <body>

                <div class="container">

                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar2">
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <span class="navbar-brand">Moje lokaty</span>
                            </div>
                            <div class="collapse navbar-collapse " id="myNavbar2">
                                <ul class="nav navbar-nav">
                                    <li><a href="<c:url value="/zalogowano" />">Strona Główna</a></li>
                                    <li><a href="<c:url value="/rachunki" />">Stan rachunku</a></li>
                                    <li><a href="<c:url value="/mojekarty" />">Moje karty</a></li>
									<li><a href="<c:url value="/kredyt" />">Moje kredyty</a></li>
									<li><a href="<c:url value="/kredyt" />">Weź kredyt</a></li>
									<li><a href="<c:url value="/mojelokaty" />">Moje lokaty</a></li>
									<li><a href="<c:url value="/nowalokata" />">Otwórz lokatę</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span>Wyloguj</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>


                    <div class="content">
                        <div class="container-fluid">
			<font size="4">
                            <ul>
                                ${informacjaOKarcie}

                                <li>
                                    ${infODacieZalLokaty1} ${dataZalLokaty1}
                                </li>
                                <li>
                                    ${infODacieZakLokaty1} ${dataZakLokaty1}
                                </li>
                                <li>
                                    ${infOKwocie1} ${kwotaLokaty1}
                                </li>
                                <li>
                                    ${infOProcencie1} ${procentLokaty1} ${proc1}
                                </li>
                                <li>
                                    ${infONaliczeniach1} ${odsetkiLokaty1}
                                </li>

                                <li>
                                    ${infODacieZalLokaty2} ${dataZalLokaty2}
                                </li>
                                <li>
                                    ${infODacieZakLokaty2} ${dataZakLokaty2}
                                </li>
                                <li>
                                    ${infOKwocie2} ${kwotaLokaty2}
                                </li>
                                <li>
                                    ${infOProcencie2} ${procentLokaty2} ${proc2}
                                </li>
                                <li>
                                    ${infONaliczeniach2} ${odsetkiLokaty2}
                                </li>

                                <li>
                                    ${infODacieZalLokaty3} ${dataZalLokaty3}
                                </li>
                                <li>
                                    ${infODacieZakLokaty3} ${dataZakLokaty3}
                                </li>
                                <li>
                                    ${infOKwocie3} ${kwotaLokaty3}
                                </li>
                                <li>
                                    ${infOProcencie3} ${procentLokaty1} ${proc3}
                                </li>
                                <li>
                                    ${infONaliczeniach3} ${odsetkiLokaty3}
                                </li>
                            </ul>
                                </font>
                        </div>
                    </div>
                </div>
            </body>

            </html>