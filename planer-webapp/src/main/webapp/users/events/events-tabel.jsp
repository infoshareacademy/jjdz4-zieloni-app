<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table id="myTable" class="table table-fixedheader table-dark">
    <thead>
    <tr>
        <th width="20%" scope="col">Data start</th>
        <th width="20%" scope="col">Data stop</th>
        <th width="20%" scope="col">Lokalizacja</th>
        <th width="15%" scope="col">Opis</th>
        <th width="25%" scope="col">Polaczenie</th>

    </tr>
    </thead>
    <tbody style="height: 400px;">

    <c:forEach var="events" items="${eventslist}">
        <form method="post" action="/suggestedBusServlet">
            <tr>
                <td width="20%">
                    <%@taglib uri="http://example.com/functions" prefix="f" %>
                    <p> ${f:formatLocalDateTime(events.startTime, 'dd.MM.yyyy, hh:mm')}</p></td>
                <td width="20%">
                    <%@taglib uri="http://example.com/functions" prefix="f" %>
                    <p> ${f:formatLocalDateTime(events.endTime, 'dd.MM.yyyy, hh:mm')}</p></td>
                <td width="20%">${events.location}</td>
                <td width="15%">${events.summary}</td>
                <td width="25%">
                    <button type="submit" name="eventId" value="${events.id}">wybierz</button>
                </td>

            </tr>
        </form>
    </c:forEach>

    </tbody>
</table>
