<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width-device-width, initial-scale=1.0">
    <title>Antykwariat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/04b1a9afda.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>"><p><i class="fas fa-book"></i>Antykwariat</p></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">
                <sec:authorize access="isAuthenticated()">
                    <a class="nav-link logged"><p class="logged-in">Zalogowany jako: <sec:authentication
                            property="principal.username"/></p></a>
                </sec:authorize>
                <a class="nav-link" href="<c:url value="/"/>">Home</a>
                <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="<c:url value="/products"/>">Produkty</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="<c:url value="/categories"/>">Kategorie</a>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <a class="nav-link" href="<c:url value="/login"/>">Logowanie</a>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <a class="nav-link" href="<c:url value="/registration"/>">Rejestracja</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <form action="<c:url value="/logout"/>" method="post">
                        <input class="nav-link" type="submit" value="Wyloguj">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </sec:authorize>
            </div>
        </div>
    </div>
</nav>
<header>
    <div class="hero-text">
        <h1>Aplikacja do zarządzania antykwariatem</h1>
    </div>
</header>