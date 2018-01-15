package com.infoshareacademy.zieloni.services;

import com.infoshareacademy.zieloni.domain.Users;

import javax.servlet.http.HttpServletRequest;

public class UserServiceBean {
  /*  private void validationNameSurname(HttpServletRequest req, Users user, String loggedUser) {

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

    }*/
}

