package com.infoshareacademy.zieloni.servlets;

import com.infoshareacademy.zieloni.database.BusDataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class ServletInitializer extends HttpServlet {

    public void init() throws ServletException {
        log("************");
        log("*** Servlet Initialized successfully--bus database is load ***..");
        log("***********");
        BusDataBase database = new BusDataBase();
        database.createDataBase();
    }
}

