<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 1200px; height: 600px;">
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
            <%--<th scope="col">ile razy edytowany</th>--%>
            <th scope="col">rola</th>
            <th scope="col">delete</th>
            <th scope="col">edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <form method="post" action="/edit-user">
                <tr <c:if test="${user.gender.toString()=='MAN'}">style="background-color: rgba(98,189,255,0.51);"</c:if>>

                    <%--<td><c:out value="${user.id}"/></td>--%>
                    <td><input type="text" class="form-control" placeholder="id" name="id" autofocus
                               value="${user.id}"></td>

                        <%--<td><c:out value="${user.name}"/>--%>
                    <td><input type="text" class="form-control" placeholder="imie" name="name" autofocus
                               value="${user.name}"></td>
                        <%-- <td><c:out value="${user.surname}"/>--%>
                    <td><input type="text" class="form-control" placeholder="nazwisko" name="surname" autofocus
                               value="${user.surname}"></td>
                        <%--<td><c:out value="${user.login}"/>--%>
                    <td><input type="text" class="form-control" placeholder="login" name="login" autofocus
                               value="${user.login}"></td>
                        <%--  <td><c:out value="${user.age}"/>--%>
                    <td><input type="text" class="form-control" placeholder="wiek" name="age" autofocus
                               value="${user.age}"></td>
                        <%-- <td><c:out value="${user.gender}"/>--%>

                        <td> <select name="gender" size="1">
                            <option VALUE="MEN">MEN</option>
                            <option VALUE="WOMAN">WOMAN</option>
                         </select></td>


                       <%-- <td><input type="text" class="form-control" placeholder="plec" name="gender" autofocus
                               value="${user.gender}"></td>--%>
                    <%--<td><c:out value="${user.statistic.editUserCounter}"/></td>--%>
                       <%-- <td><input type="text" class="form-control" placeholder="statistic" name="statistic" autofocus
                                   value="${user.statistic.editUserCounter}"></td>--%>
                        <%-- <td><c:out value="${user.role.userRole}"/>--%>
                    <td><input type="text" class="form-control" placeholder="rola" name="userRole" autofocus
                               value="${user.role.userRole}"></td>
                        <%--  <form method="post" action="/remove-user">--%>
                    <td>
                            <%--  <a href="/remove-user?id=<button class="btn btn-lg btn-primary btn-block" type="submit" name="remove" value="${user.id}"><img src="../svg/ic_delete_forever_white_24px.svg"/></button></a>--%>
                        <a href="/remove-user?id=${user.id}">
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="remove" value="${user.id}">
                                <img src="../svg/ic_delete_forever_white_24px.svg"/></button>
                        </a>
                            <%--<button class="btn btn-lg btn-primary btn-block" type="submit" name="remove" value="${user.id}"><img src="../svg/ic_delete_forever_white_24px.svg"/></button></td>--%>
                            <%-- </form>--%>
                    <td>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" name="edit" value="${user.id}"><img
                                src="../svg/ic_border_color_black_24px.svg"/></button>
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