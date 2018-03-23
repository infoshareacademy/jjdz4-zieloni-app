<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <%--One of three columns--%>
        </div>
        <div class="col-sm">
            <div class="headerText">
                <div>
                    Z WYDARZENIA NA WYDARZENIE
                </div>
            </div>
            <div class="logo">
                <img src="../images/logo1.png">
            </div>

            <c:choose>
                <c:when test="${sessionScope.isLogged == true}">
                    <c:choose>
                        <c:when test="${showCalendar}">
                            <%@ include file="users/events/events.jsp" %>
                        </c:when>
                        <c:when test="${addCalendar}">
                            <%@ include file="users/events/eventsAdd.jsp" %>
                        </c:when>
                        <c:when test="${showAbout}">
                            <%@ include file="under-constraction-page.jsp" %>
                        </c:when>
                        <c:when test="${ showRaport}">
                            <%@ include file="admin/raport/raport.jsp" %>
                        </c:when>
                        <c:when test="${showStatistics}">
                            <%@ include file="admin/statistics/statistics.jsp" %>
                        </c:when>
                        <c:when test="${showBusPromotion}">
                            <%@ include file="admin/bus-promotion/bus-promotion.jsp" %>
                        </c:when>
                        <c:when test="${showTimeTableBase}">
                            <%@ include file="users/timetable/time-table-base.jsp" %>
                        </c:when>
                        <c:when test="${showTimeTable}">
                            <%@ include file="users/timetable/show-time-table.jsp" %>
                        </c:when>
                        <c:when test="${busNr!=null}">
                            <%@ include file="users/timetable/direction-selector.jsp" %>
                        </c:when>
                        <c:when test="${busStops}">
                            <%@ include file="users/timetable/show-bus-stops.jsp" %>
                        </c:when>
                        <c:when test="${chartDependingOnGender}">
                            <%@ include file="admin/charts/chart_activity_depending_on_gender.jsp" %>
                        </c:when>
                        <c:when test="${chartDependingOnAge}">
                            <%@ include file="admin/charts/chart_activity_depending_on_age.jsp" %>
                        </c:when>
                        <c:otherwise>
                            <%@ include file="submenu.jsp" %>
                        </c:otherwise>
                    </c:choose>

                </c:when>
                <c:otherwise>
                    <%@ include file="registration/registration.jsp" %>

                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm">
            <%--One of three columns--%>
        </div>
    </div>
</div>
