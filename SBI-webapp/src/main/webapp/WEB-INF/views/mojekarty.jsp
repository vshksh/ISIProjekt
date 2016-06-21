 <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

            <!DOCTYPE html>
            <html lang="pl">

            <head>
                <title>Moje karty</title>
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
                                <span class="navbar-brand">Moje karty</span>
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
                                <li>

                                    ${informacjaOKarcie} ${numerKarty}
                                </li>
                                <li>
                                    ${infONrKarty1} ${nrKarty1} ${infODacieWaz1} ${dataWaznosciKarty1} ${infOLimicie1} ${limitKarty1} ${infOStatusie1} ${statusKarty1}
                                </li>
                                <li>
                                    ${infONrKarty2} ${nrKarty2} ${infODacieWaz2} ${dataWaznosciKarty2} ${infOLimicie2} ${limitKarty2} ${infOStatusie2} ${statusKarty2}
                                </li>
                                <li>
                                    ${infONrKarty3} ${nrKarty3} ${infODacieWaz3} ${dataWaznosciKarty3} ${infOLimicie3} ${limitKarty3} ${infOStatusie3} ${statusKarty3}
                                </li>

                            </ul>
                                
                                <p><a href="<c:url value="/historiaplatnosci"/>">Historia Płatności</a></p>
                                </font>
                        </div>
                    </div>
                </div>
            </body>

            </html>