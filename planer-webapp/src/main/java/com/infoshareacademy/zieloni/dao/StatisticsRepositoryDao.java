package com.infoshareacademy.zieloni.dao;


import com.infoshareacademy.zieloni.domain.Statistic;
import com.infoshareacademy.zieloni.domain.Users;


import javax.ejb.Local;

@Local
public interface StatisticsRepositoryDao {

    Statistic getStatisticsByLogin(String login);

    void updateStatisticsByUser(Users user);
}
