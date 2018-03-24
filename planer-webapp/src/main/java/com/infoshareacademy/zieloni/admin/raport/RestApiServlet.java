package com.infoshareacademy.zieloni.admin.raport;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest-api-raport")
public class RestApiServlet extends ShowPageViewServlet {


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {

        log("pokaż raport ");
        resetViewState(req);
        setUserRaport(req);
        showRaport(req, resp);
    }

    void setUserRaport(HttpServletRequest req) {

        RestClient client = new RestClient();
        client.getUserList();

        try {
            req.setAttribute("clientUser", client.getUserList());
        } catch (Exception e) {
            log(" nie pobrałem bazy danych");
        }
    }

    private void showRaport(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(RAPORT, true);
        showPageView(req, resp, "/index.jsp");
    }
}
