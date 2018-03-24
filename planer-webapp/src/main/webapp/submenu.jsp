<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blackshape">


    <c:choose>
        <c:when test="${sessionScope.role.equals('admin')}">
            <h3>Panel Administracyjny</h3>
            <div id="admin_menu">
                <form method="post" action="/statistic">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/group.svg" width="34" height="34"/><span
                            class="menu_text">Lista użytkowników</span>
                    </button>
                </form>
                <form method="post" action="/rest-api-raport">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/pie-chart-1.svg" width="34" height="34"/><span
                            class="menu_text">Raport aktywności</span>
                    </button>
                </form>
                <form method="post" action="/bus-promotion">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/tag-1.svg" width="34" height="34"/><span
                            class="menu_text">Promocje</span>
                    </button>
                </form>

                <form method="post" action="/chartActivityDependingOnAge">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/pie-chart.svg" width="34" height="34"/><span
                            class="menu_text">Wykres aktywności ze względu  na wiek</span>
                    </button>
                </form>
                <form method="post" action="/chartActivityDependingOnGender">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/bar-chart.svg" width="34" height="34"/><span
                            class="menu_text">Wykres aktywność ze względu na płeć</span>
                    </button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <h3>Menu</h3>
            <div id="admin_menu">
                <form method="post" action="/time-table">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/chronometer.svg" width="34" height="34"/><span
                            class="menu_text">Rozkład jazdy</span>
                    </button>
                </form>
                <form method="post" action="/events">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/settings-4.svg" width="34" height="34"/><span
                            class="menu_text">Wydarzenia</span>
                    </button>
                </form>
                <form method="post" action="/about">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/group.svg" width="34" height="34"/><span
                            class="menu_text">O nas</span>
                    </button>
                </form>

            </div>
        </c:otherwise>
    </c:choose>
</div>