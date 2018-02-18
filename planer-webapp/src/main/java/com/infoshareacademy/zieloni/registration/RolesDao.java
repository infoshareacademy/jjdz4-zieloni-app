package com.infoshareacademy.zieloni.registration;

import com.infoshareacademy.zieloni.registration.model.Roles;
import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.Local;

@Local
public interface RolesDao {
    User uesr = new User();
    Roles role_group (String login);
}
