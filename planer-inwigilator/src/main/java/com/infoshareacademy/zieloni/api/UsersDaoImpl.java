package com.infoshareacademy.zieloni.api;

import com.infoshareacademy.zieloni.api.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Stateless
public class UsersDaoImpl implements UsersDao {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public boolean addUser(User user) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MM, dd, yyyy - HH:mm:ss");
        String formattedDateTime = now.format(myFormatter);

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setLogTime(formattedDateTime);
        newUser.setLogin(user.getLogin());
        newUser.setAge(user.getAge());
        newUser.setGender(user.getGender());
        newUser.setActivity(user.getActivity());

        entityManager.persist(newUser);
        return true;
    }

    public boolean editUser(User user) {
        entityManager.createNamedQuery("updateUser")
                .setParameter("id", user.getId())
                .setParameter("name", user.getName())
                .setParameter("surname", user.getSurname())
                .executeUpdate();

        return true;
    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    public List<User> getAgeGroup(String ageGroup) {
        return entityManager.createNamedQuery(ageGroup).getResultList();
    }

    public List<User> getUsersList() {
        return entityManager.createNamedQuery("getAll").getResultList();
    }
}
