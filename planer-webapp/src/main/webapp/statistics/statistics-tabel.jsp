<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">imię</th>
        <th scope="col">nazwisko</th>
        <th scope="col">login</th>
        <th scope="col">wiek</th>
        <th scope="col">płeć</th>
        <th scope="col">rola</th>
        <th scope="col">delete</th>
        <th scope="col">edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <form method="post" action="/edit-user">
            <tr <c:if test="${user.gender.toString()=='MAN'}">style="background-color: rgba(98,189,255,0.51);"</c:if>>

                <td>${user.id}</td>
                <td><input type="text" class="form-control" name="name" value="${user.name}"></td>
                <td><input type="text" class="form-control" name="surname" value="${user.surname}"></td>
                <td><input type="text" class="form-control" name="login" value="${user.login}"></td>
                <td><input type="text" class="form-control" name="age" value="${user.age}"></td>
                <c:if test="${user.gender.toString()=='MAN'}">
                    <td><select name="gender" size="1" autofocus>
                        <option VALUE="MAN">MAN</option>
                        <option VALUE="WOMAN">WOMAN</option>
                    </select></td>
                </c:if>
                <c:if test="${user.gender.toString()=='WOMAN'}">
                    <td><select name="gender" size="1" autofocus>
                        <option VALUE="WOMAN">WOMAN</option>
                        <option VALUE="MAN">MAN</option>
                    </select></td>
                </c:if>
                <td><input type="text" class="form-control" placeholder="rola" name="userRole" autofocus
                           value="${user.role.userRole}"></td>
                <td>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="edit" value="${user.id}" style="background: rgba(98,189,255,0);border-color: rgba(98,189,255,0)">
                        <img src="../svg/ic_border_color_black_24px.svg" /></button>
                </td>

                <td>
                    <a href="/remove-user?remove=${user.id}" >
                        <img src="../svg/ic_delete_forever_white_24px.svg" style="padding-top: 10px"/>
                    </a>
                </td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>