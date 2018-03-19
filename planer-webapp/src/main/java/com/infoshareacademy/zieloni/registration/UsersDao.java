package com.infoshareacademy.zieloni.registration;

import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.Local;
import java.util.List;


@Local
public interface UsersDao {

    boolean addUser(User user);

    boolean editUser(User user);

    boolean removeUser(User user);

    User getUserById(int id);

    User getUserByLogin(String login);

    List<User> getUsersList();

}