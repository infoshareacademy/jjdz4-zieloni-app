<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 19.03.18
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<form action="/Addevents" method="post">
    <div class="form-group">

        <label for="start_time">Start time</label>
        <input type="datetime-local" class="form-control" name="start_time" id="start_time" placeholder="dd/mm/yyyy hh:mm:ss" value="${events.startTime}">

    </div>
    <div class="form-group">

        <label for="stop_time">Stop time</label>
        <input type="datetime-local" class="form-control" name="endtime" id="stop_time" placeholder="dd/mm/yyyy hh:mm:ss" value="${events.endTime}">

    </div>
    <div class="form-group">

        <label for="location">Lokalizacja</label>

          <select name="location" size="1" autofocus>
<c:forEach var="busstop" items="${location}}">
       <%--  $ulica=  "${busstop.street.toString()}" --%>
    <option value=${busstop.street}>"${busstop.street}"</option>
</c:forEach>
        </select>
       <%-- <input type="datetime-local" class="form-control" name="location" id="location" placeholder="dd/mm/yyyy hh:mm:ss" value="${stopTime}">--%>

    </div>
</form>
