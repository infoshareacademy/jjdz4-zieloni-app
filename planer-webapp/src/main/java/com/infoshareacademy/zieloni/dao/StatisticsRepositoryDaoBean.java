package com.infoshareacademy.zieloni.dao;




import com.infoshareacademy.zieloni.domain.Statistic;
import com.infoshareacademy.zieloni.domain.Users;
import com.infoshareacademy.zieloni.repository.StatisticsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class StatisticsRepositoryDaoBean implements StatisticsRepositoryDao {

    @EJB
    private StatisticsRepository statisticsRepository;


    @Override
    public Statistic getStatisticsByLogin(String login) {
        return statisticsRepository.getStatisticByLogin(login);
    }

    @Override
    public void updateStatisticsByUser(Users user) {
        statisticsRepository.updateStatisticByLogin(user);
    }
}