
package com.infoshareacademy.zieloni;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/columnchart")
public class ColumnChartServlet extends ShowPageViewServlet {
    public static Map<String, String> actualData;

    private void showCharts(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(SHOW_COLUMN_CHART, true);


        actualData = new HashMap<String, String>();

        actualData.put("Teenage", "100");
        actualData.put("Adult", "14");
        actualData.put("Mid-age", "10");
        actualData.put("Senior", "49");
        showPageView(req, resp, "/index.jsp");
    }

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCharts(req, resp);
    }
}