<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

            <!DOCTYPE html>
            <html lang="pl">

            <head>
                <title>Historia przelewów</title>
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
                                <span class="navbar-brand">Historia przelewów</span>
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
                       
                            <p> <a href="<c:url value="/nowyprzelew"/>">Wykonaj nowy przelew</a></p>
                            <ul>
                                ${informacjaOPrzelewach}
                             

                                <li>
                                    ${infODaciePrzel1} ${dataWykPrzel1}
                                </li>
                                <li>
                                    ${infOTytulePrzel1} ${tytulPrzelewu1}
                                </li>
                                <li>
                                    ${infORachOdb1} ${rachunekOdbiorcy1}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel2} ${dataWykPrzel2}
                                </li>
                                <li>
                                    ${infOTytulePrzel2} ${tytulPrzelewu2}
                                </li>
                                <li>
                                    ${infORachOdb2} ${rachunekOdbiorcy2}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel3} ${dataWykPrzel3}
                                </li>
                                <li>
                                    ${infOTytulePrzel3} ${tytulPrzelewu3}
                                </li>
                                <li>
                                    ${infORachOdb3} ${rachunekOdbiorcy3}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel4} ${dataWykPrzel4}
                                </li>
                                <li>
                                    ${infOTytulePrzel4} ${tytulPrzelewu4}
                                </li>
                                <li>
                                    ${infORachOdb4} ${rachunekOdbiorcy4}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel5} ${dataWykPrzel5}
                                </li>
                                <li>
                                    ${infOTytulePrzel5} ${tytulPrzelewu5}
                                </li>
                                <li>
                                    ${infORachOdb5} ${rachunekOdbiorcy5}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel6} ${dataWykPrzel6}
                                </li>
                                <li>
                                    ${infOTytulePrzel6} ${tytulPrzelewu6}
                                </li>
                                <li>
                                    ${infORachOdb6} ${rachunekOdbiorcy6}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel7} ${dataWykPrzel7}
                                </li>
                                <li>
                                    ${infOTytulePrzel7} ${tytulPrzelewu7}
                                </li>
                                <li>
                                    ${infORachOdb7} ${rachunekOdbiorcy7}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel8} ${dataWykPrzel8}
                                </li>
                                <li>
                                    ${infOTytulePrzel8} ${tytulPrzelewu8}
                                </li>
                                <li>
                                    ${infORachOdb8} ${rachunekOdbiorcy8}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel9} ${dataWykPrzel9}
                                </li>
                                <li>
                                    ${infOTytulePrzel9} ${tytulPrzelewu9}
                                </li>
                                <li>
                                    ${infORachOdb9} ${rachunekOdbiorcy9}
                                </li>
                                <br />
                                <li>
                                    ${infODaciePrzel10} ${dataWykPrzel10}
                                </li>
                                <li>
                                    ${infOTytulePrzel10} ${tytulPrzelewu10}
                                </li>
                                <li>
                                    ${infORachOdb10} ${rachunekOdbiorcy10}
                                </li>
     

        
                            </ul>

                                </font>
                        </div>
                    </div>
                </div>
            </body>

            </html>