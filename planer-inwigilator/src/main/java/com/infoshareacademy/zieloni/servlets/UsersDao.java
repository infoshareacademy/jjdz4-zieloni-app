package com.infoshareacademy.zieloni.servlets;


import com.infoshareacademy.zieloni.servlets.model.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UsersDao {

    boolean addUser(User user);

    boolean editUser(User user);

    Optional<User> getUserById(int id);

    List<User> getAgeGroup(String age_group);

    List<User> getUsersList();

}