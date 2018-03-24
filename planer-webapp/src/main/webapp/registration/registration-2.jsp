<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/add-user">
        <div class="form-group">
            <h3 class="form-signin-heading">Utwórz nowe konto</h3>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="error">${errorMessage}</div>
            <br>
        </c:if>
        <div class="form-group">
            <input type="email" class="form-control" placeholder="Email address" name="email" autofocus
                   value="${email}">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="hasło" name="password">
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="3">Dalej</button>
        </div>
    </form>
</div>
