package com.infoshareacademy.zieloni.services;

import com.infoshareacademy.zieloni.domain.Users;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Local
public interface IRegistrationService {

    void init(HttpServletRequest req, HttpServletResponse resp);

    void addNewUser(HttpServletRequest req, HttpServletResponse resp, String login);

    void switchMethods(HttpServletRequest req, int step, Users user, String loggedUser);

    void addToDataBase(HttpServletRequest req, Users user, String loggedUser);
}
