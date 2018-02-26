package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.registration.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-user")
public class EditUserServlet extends ShowPageViewServlet {
    private static final String EDIT_USER = "edit";

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        removeUser(req);
        setUserList(req);
        req.setAttribute(SHOW_STATISTICS_USER, true);
        showPageView(req, resp, "/index.jsp");
    }

    private void removeUser(HttpServletRequest req) {
        log(Integer.parseInt(req.getParameter(EDIT_USER)) + " klikniety remove " + req.getParameter(EDIT_USER));
        int id = Integer.parseInt(req.getParameter(EDIT_USER));
        User editUser = usersRepositoryDao.getUserById(id);
        usersRepositoryDao.editUser(editUser);
    }
}
