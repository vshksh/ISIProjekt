<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="pl">

<head>
    <title>zalogowano</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style>
        .btn-circle {
            width: 150px;
            height: 150px;
            text-align: center;
            padding: 0;
            line-height: 150px;
            border-radius: 75px;
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


        <!--kontent strony -->
        <div class="content">

            <!--jeden duzy wiersz podzielony na 1:2 -->
            <div class="row">
                <!--powitanie -->
                <div class="col-sm-3">
                    <div class="well well-sm" style="margin-top:10px; background-color: white;">
                         <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <h4>Jestes zalogowany jako : ${pageContext.request.userPrincipal.name} </h4>
                            </c:if>
                        <br />
                    </div>
                </div>
                <!--przyciski -->
                <div class="col-sm-2"></div>
                <div class="col-sm-7">
                    <div class="row">
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/histprzelewow" />" class="btn btn-default btn-circle btn-info">Przelewy <span class="glyphicon glyphicon-share"></span></a></h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/rachunki" />" class="btn btn-default btn-circle btn-info">Rachunki <span class="glyphicon glyphicon-list-alt"></span></a></h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/lokaty" />" class="btn btn-default btn-circle btn-info">Lokaty <span class="glyphicon glyphicon-refresh"></span></a></h4>
                        </div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/kredyt" />" class="btn btn-default btn-circle btn-info">Weź kredyt <span class="glyphicon glyphicon-refresh"></span></a></h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/mojekarty" />" class="btn btn-default btn-circle btn-info" >Twoje karty <span class="glyphicon glyphicon-floppy-disk"></span></a></h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/informacje" />" class="btn btn-default btn-circle btn-info" >Informacje <span class="glyphicon glyphicon-floppy-disk"></span></a></h4>
                        </div>
                    </div>
                </div>
            </div>



            <!--stopka -->
            <footer class="footer">
                <hr />
                <div class="container">
                    <div class="pull-left">SBI 2016 (<small>Dominik Paluch</small>) </div>
                    <div class="pull-right"><a href="#" style="text-decoration: none;">dpaluch92@gmail.com</a></div>
                </div>
                <br />
            </footer>
        </div>
    </div>
</body>

</html>