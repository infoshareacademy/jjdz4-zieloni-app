package com.infoshareacademy.zieloni.timetable;

import com.infoshareacademy.zieloni.RestClient;
import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest-api-raport")
public class RestApiServlet extends ShowPageViewServlet {
    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        RestClient client = new RestClient();
        client.test();
    }
}
