package com.infoshareacademy.zieloni.repository;


import com.infoshareacademy.zieloni.domain.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UsersRepository {

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
        // entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
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


}
