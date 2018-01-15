package com.infoshareacademy.zieloni.services;

import com.infoshareacademy.zieloni.domain.Roles;
import com.infoshareacademy.zieloni.domain.Statistic;
import com.infoshareacademy.zieloni.domain.Users;
import com.infoshareacademy.zieloni.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Stateless
public class AddUserServiceBean extends ValidationForm implements IAddUserService {

    @EJB
    private UsersRepository usersRepositoryDao;
    private static String registrationLevel = "sessionSignInLevel";
    private final Logger logger = LoggerFactory.getLogger(AddUserServiceBean.class.getName());
    private Users user;

    @Override
    public void init(HttpServletRequest req, HttpServletResponse resp) {
        String loggedUser = (String) req.getSession().getAttribute("loggedUser");
        addNewUser(req, resp, loggedUser);
    }

    @Override
    public void addNewUser(HttpServletRequest req, HttpServletResponse resp, String login) {
        int step = 1;

        if (req.getSession().getAttribute("user") == null) {
            user = new Users();
            req.getSession().setAttribute("user", user);
        }
        nextStep(req, step, login);
    }


    private void nextStep(HttpServletRequest req, int step, String login) {
        try {
            step = Integer.parseInt(req.getParameter("submit_button"));
        } catch (Exception e) {
            logger.info("incorrect value on press button in jsp " + e);
        }

        if (step == 5) {
            step = 1;
            user = null;
            req.getSession().setAttribute("user", null);
        }

        user = (Users) req.getSession().getAttribute("user");
        switchMethods(req, step, user, login);

    }

    public void switchMethods(HttpServletRequest req, int step, Users user, String loggedUser) {
        if (step == 1) {
            req.getSession().setAttribute(registrationLevel, step);
        } else if (step == 2) {
            validationNameSurname(req, user, loggedUser);
        } else if (step == 3) {
            validationEmailPassword(req, user);
        } else if (step == 4) {
            validationAgeGender(req, user, loggedUser);
        }
    }

    @Override
    public void addToDataBase(HttpServletRequest req, Users user, String loggedUser) {

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
            logger.info("problem z dodaniem uzytkownika " + e);
        }
        req.getSession().setAttribute(registrationLevel, 4);
    }

}

