<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/registration">
        <h2 class="form-signin-heading">${headerText}</h2>
        <br>
        <br>
        <c:if test="${errorMessage != null}">
            <div style="color: #ff2600;">${errorMessage}</div>
            <br>
        </c:if>
        <label for="age" class="sr-only">Imie </label>
        <input type="number" id="age" class="form-control" placeholder="wiek"  name="age" autofocus value="${age}">
        <br>
        <div class="radio-inline">
           <input type="radio" name="gender" value="MAN"> Mężczyzna </label>
            <input type="radio" name="gender" value="WOMAN"> Kobieta </label>
        </div>

        <br>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="4">Dalej</button>
    </form>

</div>
