package com.infoshareacademy.zieloni.admin.statistic;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.registration.model.Gender;
import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/edit-user")
public class DeactivateEditUserServlet extends ShowPageViewServlet {
    private static final String EDIT_USER = "edit";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String AGE = "age";
    private static final String GENDER_PARAMETER = "gender";

    @EJB
    StatisticsService statistic;


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        editUser(req);
        setUserList(req);

        req.setAttribute(SHOW_STATISTICS_USER, true);
        showPageView(req, resp, "/index.jsp");
    }

    public void setUserList(HttpServletRequest req) {
        req.setAttribute("userList", usersRepositoryDao.getUsersList());
    }

    private void editUser(HttpServletRequest req) {

        log(Integer.parseInt(req.getParameter(EDIT_USER)) + " klikniety edit " + req.getParameter(EDIT_USER));
        int id = Integer.parseInt(req.getParameter(EDIT_USER));

        String name = String.valueOf(req.getParameter(NAME));
        String surname = String.valueOf(req.getParameter(SURNAME));
        int age = Integer.parseInt(req.getParameter(AGE));
        Gender gender = Gender.valueOf(req.getParameter(GENDER_PARAMETER));

        User editUser = usersRepositoryDao.getUserById(id);
        editUser.setName(name);
        editUser.setSurname(surname);
        editUser.setAge(age);
        editUser.setGender(gender);

        statistic.updateStatisticsByUser(editUser, 0);


        usersRepositoryDao.editUser(editUser);
    }
}


