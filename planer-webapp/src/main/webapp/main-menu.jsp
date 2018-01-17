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
                        <c:when test="${sessionScope.openStatistics == true}">
                            <%@ include file="statistics.jsp" %>
                        </c:when>
                        <c:when test="${sessionScope.openBusSchedule == true}">
                            <%@ include file="timeSchedule.jsp" %>
                        </c:when>
                        <c:otherwise>
                            <div class="blackshape">
                                <form class="form-signin" method="post" action="/statistic">
                                    <button class="btn btn-lg btn-primary btn-block" type="submit"
                                            name="menu_button" value="">Statystyki
                                    </button>
                                </form>
                                <form class="form-signin" method="post" action="/time-schedule">
                                    <button class="btn btn-lg btn-primary btn-block" type="submit"
                                            name="menu_button" value="">Rozkład jazdy
                                    </button>
                                </form>
                            </div>
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
