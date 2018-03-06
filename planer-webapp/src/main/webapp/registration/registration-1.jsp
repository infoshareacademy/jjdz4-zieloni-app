<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blackshape">


    <form id="reg_form" class="form-signin" method="post" action="/add-user">
        <div class="form-group">
            <h3 class="form-signin-heading">Utwórz nowe konto</h3>

            <c:choose>
                <c:when test="${errorMessage != null}">
                    <div class="error">${errorMessage}</div>
                </c:when>
            </c:choose>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="imie" name="name" autofocus value="${name}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="nazwisko" name="surname" value="${surname}">
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="2">Dalej</button>
        </div>
    </form>
</div>
