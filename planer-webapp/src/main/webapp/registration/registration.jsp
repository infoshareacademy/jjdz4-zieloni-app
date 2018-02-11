<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<c:choose>
    <c:when test="${sessionScope.sessionSignInLevel == 2}">
        <%@ include file="registration-2.jsp" %>
    </c:when>
    <c:when test="${sessionScope.sessionSignInLevel == 3}">
        <%@ include file="registration-3.jsp" %>
    </c:when>
    <c:when test="${sessionScope.sessionSignInLevel == 4}">
        <%@ include file="registration-4.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="registration-1.jsp" %>
    </c:otherwise>
</c:choose>