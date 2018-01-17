package com.infoshareacademy.zieloni.servlets;

import com.infoshareacademy.zieloni.domain.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove-user")
public class RemoveUserServlet extends ShowPageViewServlet {
    private static final String REMOVE_USER = "remove";

    @Override
    void start(HttpServletRequest req, HttpServletResponse resp) {
        removeUser(req);
        setUserList(req);
        showPageView(req, resp, "/index.jsp");
    }

    private void removeUser(HttpServletRequest req) {
        log(Integer.parseInt(req.getParameter(REMOVE_USER)) + " klikniety remove " + req.getParameter(REMOVE_USER));
        int id = Integer.parseInt(req.getParameter(REMOVE_USER));
        Users removedUser = usersRepositoryDao.getUserById(id);
        usersRepositoryDao.removeUser(removedUser);
    }
}
