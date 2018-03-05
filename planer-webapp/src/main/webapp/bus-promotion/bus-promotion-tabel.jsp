<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">nazwa</th>
        <th scope="col">typ</th>
        <th scope="col">status</th>
        <th scope="col">promowanie</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="bus" items="${buslist}">
        <form method="post" action="/bus-promotion1">
            <tr style="background-color: rgba(98,189,255,0.51);">

                <td>${bus.id}</td>
                <td><input type="text" class="form-control" name="name" value="${bus.name}"></td>
                <td><input type="text" class="form-control" name="type" value="${bus.type}"></td>

                <c:if test="${bus.status.toString()=='1'}">
                <td><select name="status" size="1" >
                        <option  VALUE="1">Promocja</option>
                        <option  VALUE="0">Standart</option>
                </select></td></c:if>
                <c:if test="${bus.status.toString()=='0'}">
                    <td><select name="status" size="1" >
                        <option  VALUE="0">Standart</option>
                        <option  VALUE="1">Promocja</option>
                    </select></td></c:if>


                <td>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="promotion" value="${bus.id}" style="background: rgba(98,189,255,0);border-color: rgba(98,189,255,0)">
                        <img src="../svg/ic_border_color_black_24px.svg" /></button>
                </td>

                <%--<td>
                    <a href="/remove-user?remove=${user.id}" >
                        <img src="../svg/ic_delete_forever_white_24px.svg" style="padding-top: 10px"/>
                    </a>
                </td>--%>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>