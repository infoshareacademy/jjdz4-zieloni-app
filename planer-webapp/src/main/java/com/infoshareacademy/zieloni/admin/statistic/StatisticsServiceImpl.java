package com.infoshareacademy.zieloni.admin.statistic;

import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.admin.statistic.model.Statistic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StatisticsServiceImpl implements StatisticsService {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    @Override
    public Statistic getStatisticsByLogin(String login) {
        return (Statistic) entityManager.createNamedQuery("getStatisticsByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }
    @Override
    public void updateStatisticsByUser(User user,int num) {
        entityManager.createNamedQuery("updateStatistic")
                .setParameter("id", user.getId())
                .setParameter("num", num)
                .executeUpdate();
    }
}