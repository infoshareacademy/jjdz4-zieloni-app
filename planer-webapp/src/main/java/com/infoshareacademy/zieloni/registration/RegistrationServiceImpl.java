package com.infoshareacademy.zieloni.registration;

import com.infoshareacademy.zieloni.admin.statistic.model.Statistic;
import com.infoshareacademy.zieloni.registration.model.Roles;
import com.infoshareacademy.zieloni.registration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;


@Stateless
public class RegistrationServiceImpl extends ValidationForm implements RegistrationService {

    @EJB
    private UsersDao usersRepositoryDao;
    private static String registrationLevel = "sessionSignInLevel";
    private final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class.getName());

    @Override
    public void init(HttpServletRequest req) {
        String loggedUser = (String) req.getSession().getAttribute("loggedUser");
        addNewUser(req, loggedUser);
    }

    @Override
    public void addNewUser(HttpServletRequest req, String login) {
        int step = 1;

        User user = null;
        if (req.getSession().getAttribute("user") == null) {
            user = new User();
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
            req.getSession().setAttribute("user", null);
        }

        User user = (User) req.getSession().getAttribute("user");
        switchMethods(req, step, user, login);

    }

    public void switchMethods(HttpServletRequest req, int step, User user, String loggedUser) {
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
    public void addToDataBase(HttpServletRequest req, User user, String loggedUser) {

        Roles role = new Roles();
        role.setUserRole("user");
        role.setRoleGroup("user");

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

