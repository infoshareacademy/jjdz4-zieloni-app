package com.infoshareacademy.zieloni.api;


import com.infoshareacademy.zieloni.api.model.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UsersDao {

    boolean addUser(User user);

    boolean editUser(User user);

    Optional<User> getUserById(int id);

    List<User> getAgeGroup(String ageGroup);

    List<User> getUsersList();

}