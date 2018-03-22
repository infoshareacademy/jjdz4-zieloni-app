<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table id="myTable" class="table table-fixedheader table-dark">
    <thead>
    <tr>
        <th width="10%" scope="col">id</th>
        <th width="20%" scope="col">numer</th>
        <th width="30%" scope="col">typ</th>
        <th width="20%" scope="col">status</th>
        <th width="20%" scope="col">promowanie</th>

    </tr>
    </thead>
    <tbody style="height: 400px;">

    <c:forEach var="bus" items="${buslist}">
        <form method="post" action="/edit-bus">
            <tr>

                <td width="10%">${bus.id}</td>
                <td width="20%">${bus.name}</td>
                <td width="30%">${bus.type}</td>

                <c:if test="${bus.status.toString()=='1'}">
                    <td width="20%"><select name="status" size="1">
                        <option VALUE="1">Promocja</option>
                        <option VALUE="0">Standart</option>
                    </select></td>
                </c:if>
                <c:if test="${bus.status.toString()=='0'}">
                    <td width="20%"><select name="status" size="1">
                        <option VALUE="0">Standart</option>
                        <option VALUE="1">Promocja</option>
                    </select></td>
                </c:if>

                <td width="20%">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="promotion" value="${bus.id}"
                            style="background: rgba(98,189,255,0);border-color: rgba(98,189,255,0)">
                        <img src="../../svg/ic_forward_white_24px.svg"/></button>
                </td>

            </tr>
        </form>
    </c:forEach>

    </tbody>
</table>