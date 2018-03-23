<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<form action="/Addeve" method="post">
    <div class="form-group">

        <label for="start_time">Start time</label>
        <input type="datetime-local" class="form-control" name="start_time" id="start_time"
               placeholder="dd/mm/yyyy hh:mm:ss" value="${events.startTime}">
    </div>
    <div class="form-group">

        <label for="stop_time">Stop time</label>
        <input type="datetime-local" class="form-control" name="endtime" id="stop_time"
               placeholder="dd/mm/yyyy hh:mm:ss" value="${events.endTime}">

    </div>
    <div class="form-group">
        <select name="location" size="1" autofocus>
            <c:forEach var="busstop" items="${location}}">
                <option value=${busstop.street}></option>
            </c:forEach>
        </select>
    </div>
</form>
