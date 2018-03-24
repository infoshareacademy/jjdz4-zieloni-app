package com.infoshareacademy.zieloni.users.timetable;

import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.RecordCourseDTO;
import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.view.TimeTableView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/show-time-table")
public class ShowTimeTable extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        Integer busStopId = null;
        try {
            busStopId = Integer.parseInt(req.getParameter("busStopNr")) - 1;

        } catch (Exception e) {
            log("środek transportu jeszcze nie został wybrany");
        }

        int busId = (int) req.getSession().getAttribute(BUS_ID);
        int variant = (int) req.getSession().getAttribute(DIRECTION_VARIANT);

        String busStopName = "";
        List<RecordCourseDTO> courseRecord = null;
        Map<String, List<String>> map = null;

        if (variant == 1) {
            courseRecord = BusDataBase.getDataBase().get(busId).getCourseRecordsV1();
            map = BusDataBase.getDataBase().get(busId).getColumnsMapV1();
            busStopName = BusDataBase.getDataBase().get(busId).getBusStopsV1().get(busStopId).getNameOfBusStop().toUpperCase();

        } else if (variant == 2) {
            courseRecord = BusDataBase.getDataBase().get(busId).getCourseRecordsV2();
            map = BusDataBase.getDataBase().get(busId).getColumnsMapV2();
            busStopName = BusDataBase.getDataBase().get(busId).getBusStopsV2().get(busStopId).getNameOfBusStop().toUpperCase();
        }

        StringBuilder timeTableStringBuilder = TimeTableView.timeTableStringBuilder(courseRecord, map, busStopName, busStopId, busId);
        String timetable = timeTableStringBuilder.toString().replace("\n", "<br>");
        req.setAttribute("timetable", timetable);
        req.setAttribute(SHOW_TIME_TABLE, true);
        showPageView(req, resp, "/index.jsp");
    }


}
