package com.infoshareacademy.zieloni.statistics;


import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.statistics.model.Statistic;

import javax.ejb.Local;

@Local
public interface StatisticsService {

    Statistic getStatisticsByLogin(String login);

    void updateStatisticsByUser(User user);
}
