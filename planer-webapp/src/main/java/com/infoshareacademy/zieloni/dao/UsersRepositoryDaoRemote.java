package com.infoshareacademy.zieloni.dao;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UsersRepositoryDaoRemote {
    List<String> getUsersNames();
}