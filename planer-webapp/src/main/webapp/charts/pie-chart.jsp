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
    <h3>ROZKŁAD UŻYTKOWNIKÓW ZE WZGLĘDU NA WIEK</h3>
    <div id="chart"></div>
    <form class="form-signin" method="post" action="/main-menu">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
    </form>
</div>
<%
    FusionCharts pie3DChart = new FusionCharts(
            "pie3d",// chartType
            "chart1",// chartId
            "600", //   chartWidth
            "400",//    chartHeight
            "chart",//  chartContainer
            "json",//   dataFormat
            "{\"chart\": {\"caption\": \"Age profile of website visitors\",\"subcaption\": \"Last Year\",\"startingangle\": \"120\",\"showlabels\": \"0\",\"showlegend\": \"1\",\"enablemultislicing\": \"0\",\"slicingdistance\": \"15\",\"showpercentvalues\": \"1\",\"showpercentintooltip\": \"0\",\"plottooltext\": \"Age group : $label Total visit : $datavalue\",\"theme\": \"ocean\"},\"data\": [{\"label\": \"Teenage\",\"value\": \"12\"}, {\"label\": \"Adult\",\"value\": \"14\"}, {\"label\": \"Mid-age\",\"value\": \"10\"}, {\"label\": \"Senior\",\"value\": \"49\"}]}"
    );

%>
<!--
Render the chart
-->
<%=pie3DChart.render()%>
%>


