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
                            class="menu_text">lista użytkowników</span>
                    </button>
                </form>
                <form method="post" action="/rest-api-raport">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/pie-chart-1.svg" width="34" height="34"/><span
                            class="menu_text">raport aktywności</span>
                    </button>
                </form>
                <form method="post" action="/bus-promotion">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/tag-1.svg" width="34" height="34"/><span
                            class="menu_text">promocje</span>
                    </button>
                </form>

                <form method="post" action="/chartActivityDependingOnAge">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/pie-chart.svg" width="34" height="34"/><span
                            class="menu_text">wykres aktywności ze wzglęgu wiek</span>
                    </button>
                </form>
                <form method="post" action="/chartActivityDependingOnGender">
                    <button class="button-ms" type="submit"
                            name="menu_button" value=""><img src="../svg/bar-chart.svg" width="34" height="34"/><span
                            class="menu_text">wykres aktywność ze wzglęgu płeć</span>
                    </button>
                </form>
            </div>
        </c:when>
        <c:otherwise>

            <form class="form-signin" method="post" action="/time-table">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        name="menu_button" value="">Rozkład jazdy
                </button>
            </form>
            <form class="form-signin" method="post" action="/events">
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