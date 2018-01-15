package com.infoshareacademy.zieloni.dao;

import com.infoshareacademy.zieloni.domain.Users;

import javax.ejb.Local;
import java.util.List;


@Local
public interface UsersRepositoryDao {

    boolean addUser(Users user);

    boolean editUser(Users user);

    boolean removeUser(Users user);

    Users getUserById(int id);

    Users getUserByLogin(String login);

    List<Users> getUsersList();
}