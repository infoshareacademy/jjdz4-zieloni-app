package com.infoshareacademy.zieloni.servlets;


import com.infoshareacademy.zieloni.domain.Roles;
import com.infoshareacademy.zieloni.domain.Statistic;
import com.infoshareacademy.zieloni.domain.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends AbstractRegistration {

    private Users user;

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EDIT_USER = "editUser";
    private static final String STATISTICS_USER = "statisticsUser";
    private static final String GENDER = "gender";
    private static final String AGE = "age";
    private static String registrationLevel = "sessionSignInLevel";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req, resp);
    }

    @Override
    public void init(HttpServletRequest req, HttpServletResponse resp) {
        String loggedUser;
        try {
            loggedUser = req.getSession().getAttribute("loggedUser").toString();
            req.getSession().setAttribute("headerText", "Edycja danych");
            log(req.getSession().getAttribute(EDIT_USER) + "  jesteś zalogowany jako " + loggedUser);
        } catch (Exception e) {
            loggedUser = null;
            req.getSession().setAttribute(EDIT_USER, false);
            log("nie jesteś zalogowany" + loggedUser);
        }


            addNewUser(req, resp, loggedUser);

    }



    private void addNewUser(HttpServletRequest req, HttpServletResponse resp, String login) {
        int step = 1;

        if (req.getSession().getAttribute("user") == null) {
            user = new Users();
            req.getSession().setAttribute("user", user);
        }

        nextStep(req, resp, step, login);
    }

    private void nextStep(HttpServletRequest req, HttpServletResponse resp, int step, String login) {
        try {
            step = Integer.parseInt(req.getParameter("submit_button"));
        } catch (Exception e) {
            log("incorrect value on press button in jsp " + e);
        }

        if (step == 5) {
            step = 1;
            user = null;
            req.getSession().setAttribute("user", null);
        }

        user = (Users) req.getSession().getAttribute("user");
        validationMethods(req, step, user, login);

        try {
            req.setAttribute("userList", usersRepositoryDao.getUsersList());
        } catch (Exception e) {
            log(" brak userów");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");

        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log("problem with page: " + e);
        }
    }

    @Override
    protected String addToDataBase(HttpServletRequest req, Users user, String loggedUser) {
        String info1 = loggedUser == null ? "Nowy uzytkownik został dodany" : "Edycja danych zakonczona";

        req.getSession().setAttribute(EDIT_USER, false);

            addNewUserToDB(req, user);

        return info1;
    }

    @Override
    protected void addNewUserToDB(HttpServletRequest req, Users user) {

        Roles role = new Roles();
        role.setUserRole("admin");
        role.setRoleGroup("admin");

        Statistic statistic = new Statistic();
        statistic.setEditUserCounter(0);

        user.setRole(role);
        user.setStatistic(statistic);

        statistic.setUser(user);
        role.setUser(user);

        try {
            usersRepositoryDao.addUser(user);
        } catch (Exception e) {
            log("problem z dodaniem uzytkownika " + e);
        }
        req.getSession().setAttribute(registrationLevel, 4);
    }

}
