<%--
  Created by IntelliJ IDEA.
  User: win8
  Date: 12.03.2018
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="com.infoshareacademy.zieloni.fusioncharts.FusionCharts" %>

<div class="blackshape" style="width: 800px; height: 600px;">
    <h3>AKTYWNOŚĆ UŻYTKOWNIKÓW</h3>
    <div id="chart"></div>
    <form class="form-signin" method="post" action="/main-menu">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
    </form>
</div>
<%
    FusionCharts column2DChart = new FusionCharts(
            "column2d",// chartType
            "chart1",// chartId
            "600", //   chartWidth
            "400",//    chartHeight
            "chart",//  chartContainer
            "json",//   dataFormat
            "{\"chart\": {\"caption\": \"Raport Aktywności\",\"subCaption\": \"5 najczęściej odwiedzanych aktywności\",\"numberPrefix\": \"\",\"theme\": \"ocean\"},\"data\": [{\"label\": \"Bakersfield Central\",\"value\": \"8\"}, {\"label\": \"Garden Groove harbour\",\"value\": \"3\"}, {\"label\": \"Los Angeles Topanga\",\"value\": \"5\"}, {\"label\": \"Compton-Rancho Dom\",\"value\": \"5\"}, {\"label\": \"Daly City Serramonte\",\"value\": \"3\"}]}"
    );
%>

<%=column2DChart.render()%>

