<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 1200px; height: 600px;">
    <h3>Raport aktywności</h3>
    <div class="panel panel-default">
        <div class="panel-body">
            <table id="myTable" class="table table-fixedheader table-dark">
                <thead>
                <tr>
                    <th width="30%" scope="col">Login</th>
                    <th width="20%" scope="col">Czas</th>
                    <th width="20%" scope="col">Aktywność</th>
                    <th width="15%" scope="col">Imię</th>
                    <th width="15%" scope="col">Nazwisko</th>
                </tr>
                </thead>
                <tbody style="height:400px">

                <c:forEach var="user" items="${clientUser}" varStatus="index">
                    <form method="post" action="">
                        <tr>
                            <td width="30%"><c:out value="${user.login}"/></td>
                            <td width="20%"><c:out value="${user.logTime}"/></td>
                            <td width="20%"><c:out value="${user.activity}"/></td>
                            <td width="15%"><c:out value="${user.name}"/></td>
                            <td width="15%"><c:out value="${user.surname}"/></td>


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