package com.infoshareacademy.zieloni.services;

import com.infoshareacademy.zieloni.domain.Gender;
import com.infoshareacademy.zieloni.domain.Roles;
import com.infoshareacademy.zieloni.domain.Statistic;
import com.infoshareacademy.zieloni.domain.Users;
import com.infoshareacademy.zieloni.repository.UsersRepository;
import com.infoshareacademy.zieloni.utils.TextFormatUtil;
import org.jboss.crypto.CryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Stateless
public class RegistrationServiceBean implements IRegistrationService {

    @EJB
    private UsersRepository usersRepositoryDao;

    private static String error = "errorMessage";
    private static String registrationLevel = "sessionSignInLevel";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String GENDER = "gender";
    private final Logger logger = LoggerFactory.getLogger(RegistrationServiceBean.class.getName());

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

        nextStep(req, resp, step, login);
    }


    @Override
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


    private void nextStep(HttpServletRequest req, HttpServletResponse resp, int step, String login) {
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

        try {
            req.setAttribute("userList", usersRepositoryDao.getUsersList());
        } catch (Exception e) {
            logger.info(" brak userów");
        }

    }

    private void validationNameSurname(HttpServletRequest req, Users user, String loggedUser) {
        logger.info("validationNameSurname");

        String nameInput = req.getParameter(NAME);
        String surnameInput = req.getParameter(SURNAME);

        if (loggedUser != null && user == null) {
            user = new Users();
        }

        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute(registrationLevel, 1);
        req.setAttribute(NAME, nameInput);
        req.setAttribute(SURNAME, surnameInput);

        if (!TextFormatUtil.containOnlyAlphabetic(nameInput) || nameInput.length() < 2 || TextFormatUtil.containIllegalSign(nameInput)) {
            req.setAttribute(error, "Wpisz poprawnie imię - bez polskich liter ");
            return;
        }

        if (!TextFormatUtil.containOnlyAlphabetic(surnameInput) || surnameInput.length() < 2 || TextFormatUtil.containIllegalSign(surnameInput)) {
            req.setAttribute(error, "Wpisz poprawnie nazwisko - bez polskich liter");
            return;
        }

        user.setName(nameInput);
        user.setSurname(surnameInput);
        req.getSession().setAttribute(registrationLevel, 2);
        req.setAttribute(NAME, nameInput);
        req.setAttribute(SURNAME, surnameInput);
    }

    private void validationEmailPassword(HttpServletRequest req, Users user) {
        req.getSession().setAttribute(registrationLevel, 2);

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        req.setAttribute("email", email);

        if (isLoginExist(req, email)) {
            return;
        }
        if (email.length() < 1) {
            req.setAttribute(error, "Wpisz email");
            return;
        }
        if (password.length() < 2) {
            req.setAttribute(error, "Wpisz hasło - wiecej niz 2 znaki");
            return;
        }

        req.getSession().setAttribute(registrationLevel, 3);
        user.setEmail(email);
        user.setLogin(email);
        String hashedPassword = CryptoUtil.createPasswordHash("MD5", "hex", null, null, password);
        user.setPassword(hashedPassword);

    }

    private void validationAgeGender(HttpServletRequest req, Users user, String loggedUser) {
        logger.info("validationAgeGender");

        String gender = req.getParameter(GENDER);
        String err0 = "Wpisz poprawnie wiek";
        String err1 = "Wybierz płeć";

        req.getSession().setAttribute(registrationLevel, 3);
        int age = 0;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (Exception e) {
            logger.info("Błednie wpisany wiek" + e);
        }

        req.setAttribute("age", age);
        req.setAttribute(GENDER, gender);

        if (age <= 0) {
            req.setAttribute(error, err0);
            return;
        }
        if (gender == null) {
            req.setAttribute(error, err1);
            return;
        }
        user.setAge(age);
        setUserGender(req, user);
        addToDataBase(req, user, loggedUser);

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


    private void setUserGender(HttpServletRequest req, Users user) {
        String gender = req.getParameter(GENDER);
        if ("MAN".equals(gender)) {
            user.setGender(Gender.MAN);
        } else if ("WOMAN".equals(gender)) {
            user.setGender(Gender.WOMAN);
        } else {
            user.setGender(null);
        }
    }

    private boolean isLoginExist(HttpServletRequest req, String email) {
        try {
            usersRepositoryDao.getUserByLogin(email);
            req.setAttribute(error, "Taki login już istnieje");
            logger.info("Taki login już istniej");
            return true;
        } catch (Exception e) {
            logger.info("W bazie nie ma jeszcze usera o tym loginie" + e);
        }
        return false;
    }
}

