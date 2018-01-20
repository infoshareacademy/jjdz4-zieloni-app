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
                        <c:when test="${showStatistics}">
                            <%@ include file="statistics.jsp" %>
                        </c:when>
                        <c:when test="${showTimetable}">
                            <%@ include file="time-table-base.jsp" %>
                        </c:when>
                        <c:when test="${busNr!=null}">
                            <%@ include file="direction-selector.jsp" %>
                        </c:when>
                        <c:when test="${busStops}">
                            <%@ include file="show-bus-stops.jsp" %>
                        </c:when>
                        <c:otherwise>
                            <%@ include file="submenu.jsp" %>
                        </c:otherwise>
                    </c:choose>

                </c:when>
                <c:otherwise>
                    <%@ include file="registration.jsp" %>

                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm">
            <%--One of three columns--%>
        </div>
    </div>
</div>
