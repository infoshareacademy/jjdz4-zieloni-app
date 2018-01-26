package com.infoshareacademy.zieloni.services;

import com.infoshareacademy.zieloni.model.Statistic;
import com.infoshareacademy.zieloni.model.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StatisticsDaoService implements IStatisticsDao {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public Statistic getStatisticsByLogin(String login) {
        return (Statistic) entityManager.createNamedQuery("getStatisticsByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    public void updateStatisticsByUser(Users user) {
        entityManager.createNamedQuery("updateStatistic")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

}