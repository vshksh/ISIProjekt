<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

            <!DOCTYPE html>
            <html lang="pl">

            <head>
                <title>Panel bankiera</title>
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
                                <span class="navbar-brand">Panel bankiera</span>
                            </div>
                            <div class="collapse navbar-collapse " id="myNavbar2">
                                <ul class="nav navbar-nav">
                                    <li><a href="<c:url value="/zalogowano" />">Strona Główna</a></li>
                                    <li><a href="<c:url value="/zatwierdzkredyt"/>">Zatwierdz/odrzuć kredyt</a></li>
                                    <li><a href="<c:url value="/przejrzyjkredyt"/>">Przejrzyj kredyt</a></li>
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
                <div class="col-sm-7">
                    <div class="row">
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/zatwierdzkredyt" />" class="btn btn-default btn-circle btn-info">Zatwierdz/odrzuć kredyt<span class="glyphicon glyphicon-share"></span></a></h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><a href="<c:url value="/przejrzyjkredyt" />" class="btn btn-default btn-circle btn-info">Przejrzyj kredyt<span class="glyphicon glyphicon-list-alt"></span></a></h4>
                        </div>
                    </div>

                </div>
            </div>
                                </font>
                        </div>
                    </div>
                </div>
            </body>

            </html>