<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table id="myTable" class="table table-fixedheader table-dark">
    <thead>
    <tr>
        <th width="5%" scope="col">id</th>
        <th width="15%" scope="col">imię</th>
        <th width="15%" scope="col">nazwisko</th>
        <th width="15%" scope="col">login</th>
        <th width="10%" scope="col">wiek</th>
        <th width="10%" scope="col">płeć</th>
        <th width="10%" scope="col">rola</th>
        <th width="10%" scope="col">zatwierdź</th>
        <th width="10%" scope="col">usuń</th>
    </tr>
    </thead>
    <tbody style="height:400px">
    <c:forEach var="user" items="${userList}">
        <form method="post" action="/edit-user">
            <tr <c:if test="${user.gender.toString()=='MAN'}">style="background-color: rgba(98,189,255,0.51);"</c:if>>

                <td width="5%">${user.id}</td>
                <td width="15%"><input type="text" class="form-control" name="name" value="${user.name}"></td>
                <td width="15%"><input type="text" class="form-control" name="surname" value="${user.surname}"></td>
                <td width="15%"><input type="text" class="form-control" name="login" value="${user.login}"></td>
                <td width="10%"><input type="text" class="form-control" name="age" value="${user.age}"></td>
                <c:if test="${user.gender.toString()=='MAN'}">
                    <td width="10%"><select name="gender" size="1" autofocus>
                        <option VALUE="MAN">MAN</option>
                        <option VALUE="WOMAN">WOMAN</option>
                    </select></td>
                </c:if>
                <c:if test="${user.gender.toString()=='WOMAN'}">
                    <td width="10%"><select name="gender" size="1" autofocus>
                        <option VALUE="WOMAN">WOMAN</option>
                        <option VALUE="MAN">MAN</option>
                    </select></td>
                </c:if>
                <td width="10%"><input type="text" class="form-control" placeholder="rola" name="userRole" autofocus
                                       value="${user.role.userRole}"></td>
                <td width="10%">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="edit" value="${user.id}"
                            style="background: rgba(98,189,255,0);border-color: rgba(98,189,255,0)">
                        <img src="../../svg/ic_forward_white_24px.svg"/></button>
                </td>

                <td width="10%">
                    <a href="/remove-user?remove=${user.id}">
                        <img src="../../svg/ic_delete_forever_white_24px.svg" style="padding-top: 10px"/>
                    </a>
                </td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>