package com.infoshareacademy.zieloni.services;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Local
public interface IAddUserService {

    void init(HttpServletRequest req, HttpServletResponse resp);

    void addNewUser(HttpServletRequest req, HttpServletResponse resp, String login);

}
