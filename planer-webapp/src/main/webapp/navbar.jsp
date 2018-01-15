<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
    <a class="navbar-brand" href="#"><img src="images/logo-small.png"></a>

    <c:choose>
        <c:when test="${not empty sessionScope.isLogged && sessionScope.isLogged == true}">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <form class="form-inline"  method="get"  action="logout">

                        <div class="form-group mx-sm-3">
                            <div style="color: white">Zalogowany jako:<span class="glyphicon glyphicon-user"></span> ${sessionScope.loggedUser}</div>
                        </div>
                        <button type="submit" class="btn btn-primary" value="next">Wyloguj</button>
                    </form>
                </li>
            </ul>

        </c:when>
        <c:otherwise>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">

                    <form class="form-inline" method="post" action="sign-in">
                        <c:if test="${errorMessageSignIn != null}">
                            <div class="form-group mx-sm-3">
                                <div style="color: #ff2600;">${errorMessageSignIn}</div>
                            </div>
                        </c:if>

                        <div class="form-group mx-sm-3">
                            <input type="email" class="form-control" id="input" placeholder="E-mail"
                                   name="email">
                        </div>
                        <div class="form-group mx-sm-3">

                            <input type="password" class="form-control" id="inputPassword2" placeholder="Hasło"
                                   name="password">
                        </div>
                        <button type="submit" class="btn btn-primary" value="next">Zatwierdź</button>
                    </form>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</nav>
