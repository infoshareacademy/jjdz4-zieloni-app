package com.infoshareacademy.zieloni.services;


import com.infoshareacademy.zieloni.model.Users;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsersDaoService implements IUsersDao {

    @EJB
    private IUsersDao usersRepository;

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public boolean addUser(Users user) {
        entityManager.persist(user);
        return true;
    }

    public boolean editUser(Users user) {
        entityManager.createNamedQuery("updateUser")
                .setParameter("id", user.getId())
                .setParameter("name", user.getName())
                .setParameter("surname", user.getSurname())
                .setParameter("age", user.getAge())
                .setParameter("gender", user.getGender())
                .executeUpdate();

        return true;
    }

    public boolean removeUser(Users user) {
        Users removedUser = entityManager.find(Users.class, user.getId());
        entityManager.remove(removedUser);
        return true;
    }

    public Users getUserById(int id) {
        return entityManager.find(Users.class, id);
    }

    public Users getUserByLogin(String login) {
        return (Users) entityManager.createNamedQuery("getUserByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    public List<Users> getUsersList() {
        return entityManager.createNamedQuery("getAll").getResultList();
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
