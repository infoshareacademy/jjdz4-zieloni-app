package com.infoshareacademy.zieloni.admin.statistic;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/start-edit-user")
public class ActivateEditUserService extends ShowPageViewServlet {
    private static final String ISEDIT_USER = "isedit";
    @EJB
    StatisticsService statistic;

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        activateEditUser(req);
        setUserList(req);

        req.setAttribute(SHOW_STATISTICS_USER, true);
        showPageView(req, resp, "/index.jsp");
    }

    public void setUserList(HttpServletRequest req) {
        req.setAttribute("userList", usersRepositoryDao.getUsersList());
    }

    private void activateEditUser(HttpServletRequest req) {

        int id = Integer.parseInt(req.getParameter(ISEDIT_USER));
        User editUser = usersRepositoryDao.getUserById(id);

        statistic.updateStatisticsByUser(editUser, 1);
        usersRepositoryDao.editUser(editUser);
    }
}
