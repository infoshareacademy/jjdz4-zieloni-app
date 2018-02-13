package com.infoshareacademy.zieloni.statistics;

import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.statistics.model.Statistic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StatisticsServiceImpl implements StatisticsService {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public Statistic getStatisticsByLogin(String login) {
        return (Statistic) entityManager.createNamedQuery("getStatisticsByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    public void updateStatisticsByUser(User user) {
        entityManager.createNamedQuery("updateStatistic")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

}