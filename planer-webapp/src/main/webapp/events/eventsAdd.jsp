<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 800px; height: 600px;">
    <h3>Nowe Wydarzenia</h3>
    <%@ include file="eventsAdd-table.jsp" %>
    <form class="form-signin" method="post" action="/main-menu">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
    </form>
</div>