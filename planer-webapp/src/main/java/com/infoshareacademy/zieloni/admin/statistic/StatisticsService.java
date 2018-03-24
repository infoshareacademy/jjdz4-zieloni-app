package com.infoshareacademy.zieloni.admin.statistic;


import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.admin.statistic.model.Statistic;

import javax.ejb.Local;

@Local
public interface StatisticsService {

    Statistic getStatisticsByLogin(String login);
    void updateStatisticsByUser(User user,int num);
}
