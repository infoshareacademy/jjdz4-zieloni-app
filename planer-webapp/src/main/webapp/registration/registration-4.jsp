<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/add-user">
        <br>
        <div style="color: #26d20d;">
            <h4>Dodałeś nowego użytkownika</h4>
        </div>
        <div class="form-group">
            <div>imię:&nbsp ${user.name}</div>
        </div>
        <div class="form-group">
            <div>Nazwisko:&nbsp${user.surname}</div>
        </div>
        <div class="form-group">
            <div>Email:&nbsp ${user.email}</div>
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="5">Dalej</button>
        </div>
    </form>

</div>
