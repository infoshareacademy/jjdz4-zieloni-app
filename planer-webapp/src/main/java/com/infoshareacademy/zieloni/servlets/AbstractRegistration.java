package com.infoshareacademy.zieloni.servlets;


import com.infoshareacademy.zieloni.dao.StatisticsRepositoryDao;
import com.infoshareacademy.zieloni.dao.UsersRepositoryDao;
import com.infoshareacademy.zieloni.domain.Gender;
import com.infoshareacademy.zieloni.domain.Users;
import org.jboss.crypto.CryptoUtil;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class AbstractRegistration extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @EJB
    StatisticsRepositoryDao statisticsRepositoryDao;

    private static String error = "errorMessage";
    private static String registrationLevel = "sessionSignInLevel";
    private static String headerText = "headerText";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String GENDER = "gender";

    public abstract void init(HttpServletRequest req, HttpServletResponse resp);

    protected abstract void addNewUserToDB(HttpServletRequest req, Users user);

    protected abstract String addToDataBase(HttpServletRequest req, Users user, String loggedUser) ;

    protected void validationMethods(HttpServletRequest req, int step, Users user, String loggedUser) {


        String info = "Utwórz nowe konto";
        req.getSession().setAttribute(headerText, info);

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

    private void validationNameSurname(HttpServletRequest req, Users user, String loggedUser) {

        String nameInput = req.getParameter(NAME);
        String surnameInput = req.getParameter(SURNAME);

        if (loggedUser != null && user == null) {
            user = new Users();
        }

        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute(registrationLevel, 1);
        req.setAttribute(NAME, nameInput);
        req.setAttribute(SURNAME, surnameInput);

        if (!containOnlyAlphabetic(nameInput) || nameInput.length() < 2 || containIllegalSign(nameInput)) {
            req.setAttribute(error, "Wpisz poprawnie imię - bez polskich liter ");
            return;
        }

        if (!containOnlyAlphabetic(surnameInput) || surnameInput.length() < 2 || containIllegalSign(surnameInput)) {
            req.setAttribute(error, "Wpisz poprawnie nazwisko - bez polskich liter");
            return;
        }

        user.setName(nameInput);
        user.setSurname(surnameInput);
        req.getSession().setAttribute(registrationLevel, 2);
        req.setAttribute(NAME, nameInput);

        req.setAttribute(SURNAME, surnameInput);
        if (loggedUser != null) {
            log("pomijam edycje loginu i hasła");
            req.getSession().setAttribute(registrationLevel, 3);
        }
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

        String gender = req.getParameter(GENDER);
        String err0 = "Wpisz poprawnie wiek";
        String err1 = "Wybierz płeć";

        req.getSession().setAttribute(registrationLevel, 3);
        int age = 0;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (Exception e) {
            log("Błednie wpisany wiek" + e);
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
        String info1 = addToDataBase(req, user, loggedUser);

        req.getSession().setAttribute(headerText, info1);

    }

    private boolean isLoginExist(HttpServletRequest req, String email) {
        try {
            usersRepositoryDao.getUserByLogin(email);
            req.setAttribute(error, "Taki login już istnieje");
            return true;
        } catch (Exception e) {
            log("W bazie nie ma jeszcze usera o tym loginie" + e);
        }
        return false;
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

    private boolean containOnlyAlphabetic(String txt) {
        return txt.chars().allMatch(Character::isAlphabetic);
    }

    private boolean containIllegalSign(String txt) {
        if (txt == null) {
            return false;
        }
        String illegalRegex = "[ąćęłńóśźżĄĘŁŃÓŚŹŻ]";
        Pattern p = Pattern.compile(illegalRegex);
        Matcher checkText = p.matcher(txt);
        return checkText.find();
    }
}
