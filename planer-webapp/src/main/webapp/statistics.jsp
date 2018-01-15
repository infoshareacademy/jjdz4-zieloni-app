<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 800px;">
    <h3>STATYSTYKI</h3>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">imię</th>
            <th scope="col">nazwisko</th>
            <th scope="col">login</th>
            <th scope="col">wiek</th>
            <th scope="col">płeć</th>
            <th scope="col">ile razy edytowany</th>
            <th scope="col">rola</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <form method="post" action="/registration">
                <tr <c:if test="${user.gender.toString()=='MAN'}">style="background-color: rgba(98,189,255,0.51);"</c:if>>

                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.surname}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.age}"/></td>
                    <td><c:out value="${user.gender}"/></td>
                    <td><c:out value="${user.statistic.editUserCounter}"/></td>
                    <td><c:out value="${user.role.userRole}"/></td>
                    <td>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" name="remove" value="${user.id}"><img src="svg/ic_delete_forever_white_24px.svg"/></button>
                    </td>

                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

    <form class="form-signin" method="post" action="/registration">
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="edit_button" value="closeStatistics">Wróć
        </button>
    </form>
</div>