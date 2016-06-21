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
                                            ${brakRachunku}
                                            <li>
                                                ${infORachunku1} ${nrRachunku1}
                                            </li>
                                            <li>
                                                ${infOSaldzie1} ${saldo1}
                                            </li>
                                            <li>
                                                ${infORachunku2} ${nrRachunku2}
                                            </li>
                                            <li>
                                                ${infOSaldzie2} ${saldo2}
                                            </li>
                                            <li>
                                                ${infORachunku3} ${nrRachunku3}
                                            </li>
                                            <li>
                                                ${infOSaldzie3} ${saldo3}
                                            </li>
                                        </ul>
                            </font>
                        </div>
                    </div>
                </div>
            </body>

            </html>