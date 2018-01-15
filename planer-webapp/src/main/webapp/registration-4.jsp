<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/registration">
        <br>
        <div style="color: #26d20d;">
            <h4>${headerText}</h4>
        </div>
        <br>
        <div>imię:&nbsp ${user.name}</div>
        <br>
        <div>Nazwisko:&nbsp${user.surname}</div>
        <br>
        <div>Email:&nbsp ${user.email}</div>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="5">Dalej</button>
    </form>

</div>
