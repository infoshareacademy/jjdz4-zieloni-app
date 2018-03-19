package com.infoshareacademy.zieloni.servlets;


import com.infoshareacademy.zieloni.servlets.model.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UsersDao {

    boolean addUser(User user);

    boolean editUser(User user);

    boolean removeUser(User user);

    Optional<User> getUserById(int id);

    Optional<User> getUserByLogin(String login);

    List<User> getUsersList();

}