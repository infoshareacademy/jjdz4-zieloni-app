
package com.infoshareacademy.zieloni.admin.charts;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.admin.raport.RestClient;
import com.infoshareacademy.zieloni.admin.raport.exception.InwigilatorNotFoundException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/chartActivityDependingOnAge")
public class ChartActivityDependingOnAge extends ShowPageViewServlet {
    public static Map<String, String> actualData;

    private void showCharts(HttpServletRequest req, HttpServletResponse resp) {
        String childrenSize;
        String teenageSize;
        String adultSize;
        String seniorSize;

        req.setAttribute(SHOW_CHART_DEPENDING_ON_AGE, true);
        RestClient client = new RestClient();
        actualData = new HashMap<String, String>();

        childrenSize = numberOfUserInAge(client, "children");
        teenageSize = numberOfUserInAge(client, "teenage");
        adultSize = numberOfUserInAge(client, "adult");
        seniorSize = numberOfUserInAge(client, "senior");

        actualData.put("Dzieci", childrenSize);
        actualData.put("Młodzież", teenageSize);
        actualData.put("Dorośli", adultSize);
        actualData.put("Seniorzy", seniorSize);
        showPageView(req, resp, "/index.jsp");

    }

    private String numberOfUserInAge(RestClient client, String age) {
        String list;
        try {
            list = String.valueOf(client.getDataOfUserAge(age).size());
        } catch (NullPointerException e) {
            list = "0";
        }
        return list;
    }

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCharts(req, resp);
    }
}