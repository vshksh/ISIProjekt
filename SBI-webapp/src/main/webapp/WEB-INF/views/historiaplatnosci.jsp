<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

            <!DOCTYPE html>
            <html lang="pl">

            <head>
                <title>Moje rachunki</title>
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
                                <span class="navbar-brand">Moje rachunki</span>
                            </div>
                            <div class="collapse navbar-collapse " id="myNavbar2">
                                <ul class="nav navbar-nav">
                                    <li><a href="<c:url value="/zalogowano" />">Strona Główna</a></li>
                                    <li><a href="<c:url value="/rachunki" />">Stan rachunku</a></li>
                                    <li><a href="<c:url value="/mojekarty" />">Moje karty</a></li>
                                    <li><a href="<c:url value="/kredyt" />">Moje kredyty</a></li>
                                    <li><a href="<c:url value="/bierzkredyt" />">Weź kredyt</a></li>
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
                    <c:forEach begin="0" end="${ileplatnosci-1}" var="i">
                        <c:set var="IDPlatnoscipomoc" value="IDPlatnosci${i}" />
                        <c:set var="kwotapomoc" value="kwota${i}" />
                        <c:set var="nazwapomoc" value="nazwa${i}" />
                        <c:set var="dataPlatnoscipomoc" value="dataPlatnosci${i}" />
                        <c:set var="IDPlatnosci" scope="page" value="${requestScope[IDPlatnoscipomoc]}"/> 
                        <c:set var="kwota" scope="page" value="${requestScope[kwotapomoc]}"/>
                        <c:set var="nazwa" scope="page" value="${requestScope[nazwapomoc]}"/>
                        <c:set var="dataPlatnosci" scope="page" value="${requestScope[dataPlatnoscipomoc]}"/>
                        ID płatności: ${i+1}: ${IDPlatnosci} <br>
                        Kwota płatności:  ${i+1}: ${kwota}<br>
                        Tytuł:  ${i+1}: ${nazwa}<br>
                        Data wykonania płatności: ${i+1}: ${dataPlatnosci}<br>
                        <br>
                        <br>
                    </c:forEach>

            </ul>
                            </font>
                        </div>
                    </div>
                </div>
            </body>

            </html>
