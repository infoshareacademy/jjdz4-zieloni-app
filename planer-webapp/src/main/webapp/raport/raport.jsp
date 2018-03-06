<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 800px; height: 600px;">
    <h3>Rozkład jazdy</h3>
    <div class="panel panel-default">
        <div class="panel-body">
            <table id="myTable" class="table table-fixedheader table-dark">
                <thead>
                <tr>
                    <th width="10%" scope="col">id</th>
                    <th width="20%" scope="col">Numer</th>
                    <th width="50%" scope="col">Typ</th>
                    <th width="20%" scope="col">wybierz</th>
                </tr>
                </thead>
                <tbody style="height:400px">

                <c:forEach var="user" items="${clientUser}" varStatus="index">
                    <form method="post" action="">
                        <tr>
                            <td width="10%"><c:out value="${user.id}"/></td>
                            <td width="20%"><c:out value="${user.name}"/></td>
                            <td width="50%"><c:out value="${user.surname}"/></td>
                            <td width="20%">
                                <button type="submit" name="busNr" value="${index.count}">wybierz</button>
                            </td>

                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <form class="form-signin" method="post" action="/main-menu">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
            </form>
        </div>
    </div>
</div>