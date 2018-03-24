<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/add-user">
        <h3 class="form-signin-heading">Utwórz nowe konto</h3>
        <c:if test="${errorMessage != null}">
            <div class="error">${errorMessage}</div>
        </c:if>
        <div class="form-group">
            <input type="number" id="age" class="form-control" placeholder="wiek" name="age" autofocus value="${age}">
        </div>
        <div class="radio-inline">
            <input type="radio" name="gender" value="MAN"> Mężczyzna </label>
            <input type="radio" name="gender" value="WOMAN"> Kobieta </label>
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="4">Dalej</button>
        </div>
    </form>

</div>
