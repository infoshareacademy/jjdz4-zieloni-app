package com.infoshareacademy.zieloni.registration;


import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UsersDaoImpl implements UsersDao {


    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
    private static final String EDIT_USER = "edit";

    public boolean addUser(User user) {
        entityManager.persist(user);
        return true;
    }

    public boolean editUser(User user) {
        entityManager.createNamedQuery("updateUser")
                .setParameter("id", user.getId())
                .setParameter("name", user.getName())
                .setParameter("surname", user.getSurname())
                .setParameter("age", user.getAge())
                .setParameter("gender", user.getGender())
                .executeUpdate();

        return true;
    }

    public boolean removeUser(User user) {
        User removedUser = entityManager.find(User.class, user.getId());
        entityManager.remove(removedUser);
        return true;
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByLogin(String login) {
        return (User) entityManager.createNamedQuery("getUserByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    public List<User> getUsersList() {
        return entityManager.createNamedQuery("getAll").getResultList();
    }

}
