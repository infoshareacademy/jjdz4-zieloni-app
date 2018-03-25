<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 800px; height: 600px;">
    <h3>Wybierz Przystanek</h3>
    <div class="panel panel-default">
        <div class="panel-body">
            <table id="myTable" class="table table-fixedheader table-dark">
                <thead>
                <tr>
                    <th width="10%" scope="col">nr</th>
                    <th width="70%" scope="col">przystanek</th>
                    <th width="20%" scope="col">wybierz</th>
                </tr>
                </thead>
                <tbody style="height:400px">

                <c:forEach var="busStop" items="${busStopList}" varStatus="index">
                    <form method="post" action="/show-time-table">
                        <tr>
                            <td width="10%"><c:out value="${index.count}"/></td>
                            <td width="70%"><c:out value="${busStop.getNameOfBusStop()}"/></td>
                            <td width="20%">
                                <button type="submit" name="busStopNr" value="${index.count}">wybierz</button>
                            </td>

                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <form class="form-signin" method="post" action="/time-table">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
            </form>
        </div>
    </div>
</div>