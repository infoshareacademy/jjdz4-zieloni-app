<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blackshape">
    <form class="form-signin" method="post" action="/statistic">
        <button class="btn btn-lg btn-primary btn-block" type="submit"
                name="menu_button" value="">Statystyki
        </button>
    </form>
    <form class="form-signin" method="post" action="/time-table">
        <button class="btn btn-lg btn-primary btn-block" type="submit"
                name="menu_button" value="">Rozkład jazdy
        </button>
    </form>
    <form class="form-signin" method="post" action="">
        <button class="btn btn-lg btn-primary btn-block" type="submit"
                name="menu_button" value="">Kalendarz</button>
    </form>

</div>