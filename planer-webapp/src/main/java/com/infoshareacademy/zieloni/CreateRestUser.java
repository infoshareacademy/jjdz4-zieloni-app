package com.infoshareacademy.zieloni;


import com.infoshareacademy.zieloni.raport.RestClient;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createRestUser")
public class CreateRestUser extends ShowPageViewServlet {
    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        RestClient client = new RestClient();
        client.infoAboutUserActivity("test");
    }
}
