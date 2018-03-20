<%@page import="com.google.gson.Gson" %>
<%@page import="com.infoshareacademy.zieloni.admin.charts.ChartActivityDependingOnAge" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="com.infoshareacademy.zieloni.admin.fusioncharts.FusionCharts" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>

<div class="blackshape" style="width: 800px; height: 600px;">
    <h3>Aktywność użytkowników ze względu na wiek</h3>
    <div id="chart"></div>
    <form class="form-signin" method="post" action="/main-menu">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Wróć</button>
    </form>
</div>


<%
    Gson gson = new Gson();

    Map<String, String> chartobj = new HashMap<String, String>();

    chartobj.put("caption", "");
    chartobj.put("subCaption", "");
    chartobj.put("paletteColors", "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000");
    chartobj.put("bgColor", "#ffffff");
    chartobj.put("showBorder", "0");
    chartobj.put("use3DLighting", "0");
    chartobj.put("showShadow", "0");
    chartobj.put("enableSmartLabels", "0");
    chartobj.put("startingAngle", "0");
    chartobj.put("showPercentValues", "1");
    chartobj.put("showPercentInTooltip", "0");
    chartobj.put("decimals", "1");
    chartobj.put("captionFontSize", "0");
    chartobj.put("subcaptionFontSize", "0");
    chartobj.put("subcaptionFontBold", "0");
    chartobj.put("toolTipColor", "#ffffff");
    chartobj.put("toolTipBorderThickness", "0");
    chartobj.put("toolTipBgColor", "#000000");
    chartobj.put("toolTipBgAlpha", "80");
    chartobj.put("toolTipBorderRadius", "2");
    chartobj.put("toolTipPadding", "5");
    chartobj.put("showHoverEffect", "1");
    chartobj.put("showLegend", "1");
    chartobj.put("legendBgColor", "#ffffff");
    chartobj.put("legendBorderAlpha", "0");
    chartobj.put("legendShadow", "0");
    chartobj.put("legendItemFontSize", "22");
    chartobj.put("legendItemFontColor", "#666666");
    chartobj.put("useDataPlotColorForLabels", "1");

    ArrayList arrData = new ArrayList();

    for (Map.Entry m : ChartActivityDependingOnAge.actualData.entrySet()) {
        Map<String, String> lv = new HashMap<String, String>();
        lv.put("label", (String) m.getKey());
        lv.put("value", (String) m.getValue());
        arrData.add(lv);
    }

    Map<String, String> dataMap = new LinkedHashMap<String, String>();

    dataMap.put("chart", gson.toJson(chartobj));
    dataMap.put("data", gson.toJson(arrData));
    FusionCharts columnChart = new FusionCharts(
            "pie3d",// chartType
            "chart1",// chartId
            "600", "400",// chartWidth, chartHeight
            "chart",// chartContainer
            "json",// dataFormat
            gson.toJson(dataMap) //dataSource
    );
%>
<%=columnChart.render()%>
