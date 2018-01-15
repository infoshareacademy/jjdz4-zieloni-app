package com.infoshareacademy.zieloni.dao;


import com.infoshareacademy.zieloni.domain.Users;
import com.infoshareacademy.zieloni.repository.UsersRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao, UsersRepositoryDaoRemote {

    @EJB
    private UsersRepository usersRepository;


    @Override
    public boolean addUser(Users user) {
        usersRepository.addUser(user);

        return true;
    }

    @Override
    public boolean editUser(Users user) {
        usersRepository.editUser(user);
        return true;
    }

    @Override
    public boolean removeUser(Users user) {

        usersRepository.removeUser(user);
        return true;
    }

    @Override
    public Users getUserById(int id) {
        return usersRepository.getUserById(id);
    }

    @Override
    public Users getUserByLogin(String login) {
        return usersRepository.getUserByLogin(login);
    }

    @Override
    public List<Users> getUsersList() {
        return usersRepository.getUsersList();
    }

    @Override
    public List<String> getUsersNames() {
        List<String> usersNames = new ArrayList<>();
        for (Users user : getUsersList()) {
            usersNames.add(user.getName());
        }
        return usersNames;
    }
}
