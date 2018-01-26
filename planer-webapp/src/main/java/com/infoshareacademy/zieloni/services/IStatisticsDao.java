package com.infoshareacademy.zieloni.services;


import com.infoshareacademy.zieloni.model.Statistic;
import com.infoshareacademy.zieloni.model.Users;

import javax.ejb.Local;

@Local
public interface IStatisticsDao {

    Statistic getStatisticsByLogin(String login);

    void updateStatisticsByUser(Users user);
}
