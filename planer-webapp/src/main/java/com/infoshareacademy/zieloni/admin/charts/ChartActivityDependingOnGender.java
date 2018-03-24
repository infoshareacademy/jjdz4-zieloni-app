package com.infoshareacademy.zieloni.admin.charts;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.admin.raport.RestClient;
import com.infoshareacademy.zieloni.admin.raport.exception.InwigilatorNotFoundException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/chartActivityDependingOnGender")
public class ChartActivityDependingOnGender extends ShowPageViewServlet {
    public static Map<String, String> actualGenderData;

    private void showCharts(HttpServletRequest req, HttpServletResponse resp) {
        String manSize;
        String womanSize;

        req.setAttribute(SHOW_CHART_DEPENDING_ON_GENDER, true);
        RestClient client = new RestClient();
        actualGenderData = new HashMap<>();

        manSize = numberOfUserInAge(client, "man");
        womanSize = numberOfUserInAge(client, "woman");

        actualGenderData.put("Kobiety", womanSize);
        actualGenderData.put("Mężczyźni", manSize);

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