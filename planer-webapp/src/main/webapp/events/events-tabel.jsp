<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 19.03.18
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table id="myTable" class="table table-fixedheader table-dark">
    <thead>
    <tr>
        <%--<th width="10%" scope="col">id</th>--%>
        <th width="20%" scope="col">Data  start</th>
        <th width="20%" scope="col">Data  stop</th>
        <th width="30%" scope="col">Lokalizacja / ulica</th>
        <th width="30%" scope="col">Opis</th>

    </tr>
    </thead>
    <tbody style="height: 400px;">

    <c:forEach var="events" items="${eventslist}">
        <form method="post" action="/events">
            <tr style="background-color: rgba(98,189,255,0.51);">

              <%--  <td width="10%">${events.id}</td>--%>
                <td width="20%">${events.startTime}</td>
                <td width="20%">${events.endTime}</td>
                  <select name=${busstop.location} size="1" autofocus>
                  </select>
                <td width="30%">${busstop.location}</td>
                <td width="30%">${events.summary}</td>


                <td width="20%">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="events" value="${events.id}"
                            style="background: rgba(98,189,255,0);border-color: rgba(98,189,255,0)">
                        <img src="../svg/ic_border_color_black_24px.svg"/></button>
                </td>

            </tr>
        </form>
    </c:forEach>

    </tbody>
</table>
