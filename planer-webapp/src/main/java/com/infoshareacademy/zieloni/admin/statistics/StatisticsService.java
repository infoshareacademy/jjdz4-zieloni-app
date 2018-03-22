package com.infoshareacademy.zieloni.admin.statistics;


import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.admin.statistics.model.Statistic;

import javax.ejb.Local;

@Local
public interface StatisticsService {

    Statistic getStatisticsByLogin(String login);
    void updateStatisticsByUser(User user,int num);
}
