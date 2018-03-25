<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table id="myTable" class="table table-fixedheader table-dark">
    <thead>
    <tr>
        <th width="15%" scope="col">Data start</th>
        <th width="15%" scope="col">Data stop</th>
        <th width="20%" scope="col">Lokalizacja</th>
        <th width="25%" scope="col">Opis</th>
        <th width="25%" scope="col">Polaczenie</th>

    </tr>
    </thead>
    <tbody style="height: 400px;">

    <c:forEach var="events" items="${eventslist}" varStatus="loop">
        <form method="post" action="/suggestedBusServlet">
            <tr>
                <td width="15%">
                    <%@taglib uri="http://example.com/functions" prefix="f" %>
                    <p> ${f:formatLocalDateTime(events.startTime, 'dd.MM.yyyy, hh:mm')}</p></td>
                <td width="15%">
                    <%@taglib uri="http://example.com/functions" prefix="f" %>
                    <p> ${f:formatLocalDateTime(events.endTime, 'dd.MM.yyyy, hh:mm')}</p></td>
                <td width="20%">${events.location}</td>
                <td width="25%">${events.summary}</td>
                <td width="25%">
                    <c:choose>
                        <c:when test="${loop.index != eventslist.size()-1}">
                            <button type="submit" name="eventId" value="${events.id}">proponuj</button>
                        </c:when>
                    </c:choose>
                </td>

            </tr>
        </form>
    </c:forEach>

    </tbody>
</table>
