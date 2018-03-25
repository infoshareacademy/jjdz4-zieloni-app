<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="blackshape" style="width: 800px; height: 500px;">
    <h3>nr: ${busNr} </h3>
    <h3> Typ: ${type_of_tranport}</h3>
    <h6>Wybierz kierunek</h6>
    <form method="post" action="/show-bus-stops">
        <button class="button-ms" type="submit" name="variant" value="1">${busStopsV1}</button>
    </form>
    <form  method="post" action="/show-bus-stops">
        <button class="button-ms" type="submit" name="variant" value="2" >${busStopsV2}</button>
    </form>
    <form class="form-signin" method="post" action="/time-table">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
    </form>
</div>