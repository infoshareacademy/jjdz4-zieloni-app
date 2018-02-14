package com.infoshareacademy.zieloni.registration;

import com.infoshareacademy.zieloni.registration.model.Gender;
import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.utils.TextFormatUtil;
import org.jboss.crypto.CryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

abstract class ValidationForm {

    @EJB
    private UsersDao usersRepositoryDao;

    private static String error = "errorMessage";
    private static String registrationLevel = "sessionSignInLevel";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String GENDER_PARAMETER = "gender";
    private final Logger logger = LoggerFactory.getLogger(ValidationForm.class.getName());

    abstract void addToDataBase(HttpServletRequest req, User user, String loggedUser);

    protected void validationNameSurname(HttpServletRequest req, User user, String loggedUser) {
        logger.info("validationNameSurname");

        String nameInput = req.getParameter(NAME);
        String surnameInput = req.getParameter(SURNAME);

        if (loggedUser != null && user == null) {
            user = new User();
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

    protected void validationEmailPassword(HttpServletRequest req, User user) {
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

    protected void validationAgeGender(HttpServletRequest req, User user, String loggedUser) {
        logger.info("validationAgeGender");

        String gender = req.getParameter(GENDER_PARAMETER);
        String err0 = "Wpisz poprawnie wiek";
        String err1 = "Wybierz płeć";

        req.getSession().setAttribute(registrationLevel, 3);
        int age = 0;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException e) {
            logger.info("Błednie wpisany wiek" + e);
        }

        req.setAttribute("age", age);
        req.setAttribute(GENDER_PARAMETER, gender);

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


    private void setUserGender(HttpServletRequest req, User user) {
        String gender = req.getParameter(GENDER_PARAMETER);
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
