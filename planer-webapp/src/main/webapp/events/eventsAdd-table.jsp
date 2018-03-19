<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 19.03.18
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<form action="/Addevents" method="post">
   <thead>
    <tr>
        <th> <label for="Startmeeting">Start wydarzenia : </label></th>
        <th><label for="Stopmeeting">Stop wydarzenia : </label></th>
        <th><label for="location">Przystanek </label></th>
    </tr>
    </thead>
<tr>
        <td><input id="Startmeeting" type="datetime-local" value="2011-01-13 12:00"/></td>
        <td><input id="Stopmeeting" type="datetime-local" value="2011-01-13 12:00"/></td>
    <td><input type="text" class="form-control" id="location" value="${events.location}"></td>
</tr>
</form>