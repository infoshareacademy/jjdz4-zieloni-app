package com.infoshareacademy.zieloni.servlets.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class UserStore {

    private Logger LOG = LoggerFactory.getLogger(UserStore.class);

    private Map<Integer, User> base;

    public Map<Integer, User> getBase() {
        return base;
    }

    public UserStore() {
        LOG.info("initializing user store");
        base = new HashMap<Integer, User>();

        User user1 = new User("Adam", "Iksinski", 1,
            new Credentials("adam", "haslo123"));

        User user2 = new User("Karol", "Ygrekowski", 2,
            new Credentials("karoly", "123456"));

        base.put(user1.getId(), user1);
        base.put(user2.getId(), user2);
    }

    public int getNewId() {
        //return base.keySet().stream()
                //.reduce(0, (acc, n) -> n > acc ? n : acc) + 1;

        return  base.keySet().stream()
                .mapToInt(i -> i)
                .max().orElse(0) + 1;
    }

    public void add(User user) {
        LOG.info("Adding to store: " + user.toString());
        base.put(user.getId(), user);
    }

    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(base.get(id));
    }

    public boolean authenticate(String username, String password) {
        return base.values().stream()
                .map(User::getCredentials)
                .anyMatch(c -> c.getUser().equals(username)
                    && c.getPassword().equals(password));
    }
}
