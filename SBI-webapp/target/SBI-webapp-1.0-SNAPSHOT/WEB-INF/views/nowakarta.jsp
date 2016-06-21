<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

            <%@page contentType="text/html" pageEncoding="UTF-8"%>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

                        <!DOCTYPE html>
                        <html lang="pl">

                        <head>
                            <title>Bankowość Internetowa</title>
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

                                <!--navigacja po zalogowaniu -->
                                <nav class="navbar navbar-default">
                                    <div class="container-fluid">
                                        <div class="navbar-header">
                                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar2">
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                            </button>
                                            <span class="navbar-brand">Konto</span>
                                        </div>
                                        <div class="collapse navbar-collapse " id="myNavbar2">
                                            <ul class="nav navbar-nav">
                                                <li><a href="<c:url value=" /zalogowano " />">Profil</a></li>
                                                <li class="dropdown">
                                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Odbiorcy<span class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="#">Dodaj odbiorcę</a></li>
                                                        <li><a href="#">Lista odbiorców</a></li>
                                                    </ul>
                                                </li>
                                                <li class="dropdown">
                                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Wiadomości<span class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="#">Napisz wiadomość</a></li>
                                                        <li><a href="#">Sprawdź skrzynkę </a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Zlecenia stałe</a></li>
                                                <li><a href="#">Kredyty</a></li>
                                            </ul>
                                            <ul class="nav navbar-nav navbar-right">
                                                <li>
                                                    <a href="<c:url value=" /logout " />"><span class="glyphicon glyphicon-log-out"></span> Wyloguj</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </nav>

                                <div class="content">
                                    <div class="container-fluid">
                                        <form:form method="POST" modelAttribute="karta">
                                            <!-- modelAttribute - klasa, którą wysłał kontroler-->
                                            <!-- Pola form:input odpowiadają polom tej klasy -->
                                            <table>
                                                <tr>
                                                    <th>Podaj numer PIN:</th>
                                                    <td>
                                                        <form:input type="password" path="PIN" />
                                                        <form:errors path="PIN" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>Podaj limit dla karty:</th>
                                                    <td>
                                                        <form:input type="number" path="limitKarty" />
                                                        <form:errors path="limitKarty" />
                                                    </td>
                                                </tr>
                                            </table>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" input type="submit" class="btn btn-default">Dodaj</button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </body>

                        </html>