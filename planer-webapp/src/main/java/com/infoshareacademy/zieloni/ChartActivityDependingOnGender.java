package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.raport.RestClient;
import com.infoshareacademy.zieloni.raport.exception.InwigilatorNotFoundException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/chartActivityDependingOnGender")
public class ChartActivityDependingOnGender extends ShowPageViewServlet {
    public static Map<String, String> actualData1;
    private void showCharts(HttpServletRequest req, HttpServletResponse resp) {
        String childrenSize;
        String teenageSize;
        String adultSize;
        String seniorSize;

        req.setAttribute(SHOW_CHART_DEPENDING_ON_GENDER, true);
        RestClient client = new RestClient();
        actualData1 = new HashMap<String, String>();

        childrenSize = numberOfUserInAge(client, "children");
        teenageSize = numberOfUserInAge(client, "teenage");
        adultSize = numberOfUserInAge(client, "adult");
        seniorSize = numberOfUserInAge(client, "senior");

        actualData1.put("Kobiety", childrenSize);
        actualData1.put("Mężczyźni", teenageSize);

        showPageView(req, resp, "/index.jsp");

    }

    private String numberOfUserInAge(RestClient client, String age) {
        String list;
        try {
            list = String.valueOf(client.getDataOfUserAge(age).size());
        } catch (InwigilatorNotFoundException e) {
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