<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blackshape">


    <c:choose>
        <c:when test="${sessionScope.role.equals('admin')}">
            <form class="form-signin" method="post" action="/statistic">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">Lista użytkowników
                </button>
            </form>
            <form class="form-signin" method="post" action="/rest-api-raport">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">Raport aktywności
                </button>
            </form>
            <form class="form-signin" method="post" action="/bus-promotion">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">Promocja
                </button>
            </form>
        </c:when>
        <c:otherwise>

            <form class="form-signin" method="post" action="/time-table">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">Rozkład jazdy
                </button>
            </form>
            <form class="form-signin" method="post" action="/calendar">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">Kalendarz
                </button>
            </form>
            <form class="form-signin" method="post" action="/about">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">O nas
                </button>
            </form>
        </c:otherwise>
    </c:choose>
</div>