package com.infoshareacademy.zieloni;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main-menu")
public class MainMenuServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showPageView(req, resp, "/index.jsp");
    }
}
