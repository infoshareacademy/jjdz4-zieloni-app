package com.infoshareacademy.zieloni.users.timetable;

import com.infoshareacademy.zieloni.database.BusDataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class ServletInitializer extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log("************");
        log("*** Servlet Initialized successfully--bus database is load ***..");
        log("***********");
        BusDataBase database = new BusDataBase();
        database.createDataBase();
    }
}

