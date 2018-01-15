<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blackshape">
    <form id="reg_form" class="form-signin" method="post" action="/registration">
        <c:choose>
            <c:when test="${headerText== null}">
                <h2 class="form-signin-heading">Utwórz nowe konto</h2>
            </c:when>
            <c:otherwise>
                <h2 class="form-signin-heading">${headerText}</h2>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${errorMessage != null}">
                <div style="color: #ff2600;">${errorMessage}</div>
                <br>
            </c:when>
        </c:choose>
        <input type="text" class="form-control" placeholder="imie" name="name" autofocus value="${name}">
        <br>
        <label class="sr-only">nazwisko</label>
        <input type="text" class="form-control" placeholder="nazwisko" name="surname" value="${surname}">
        <br>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="2">Dalej</button>
        <br>
    </form>
</div>
