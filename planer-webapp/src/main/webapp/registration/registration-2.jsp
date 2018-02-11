<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/add-user">
        <h2 class="form-signin-heading">${headerText}</h2>
        <br>
        <br>
        <c:if test="${errorMessage != null}">
            <div style="color: #ff2600;">${errorMessage}</div>
            <br>
        </c:if>
        <label class="sr-only">Email </label>
        <input type="email" class="form-control" placeholder="Email address" name="email" autofocus  value="${email}">
        <br>

        <label class="sr-only">Password</label>
        <input type="password" class="form-control" placeholder="hasło" name="password" >
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit_button" value="3">Dalej</button>
        <br>
    </form>
</div>
