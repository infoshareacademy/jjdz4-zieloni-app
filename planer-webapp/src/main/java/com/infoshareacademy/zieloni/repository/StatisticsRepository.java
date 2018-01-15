package com.infoshareacademy.zieloni.repository;



import com.infoshareacademy.zieloni.domain.Statistic;
import com.infoshareacademy.zieloni.domain.Users;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StatisticsRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    @EJB
    StatisticsRepository statisticRepository;

    public Statistic getStatisticByLogin(String login) {
        return (Statistic) entityManager.createNamedQuery("getStatisticsByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    public void updateStatisticByLogin(Users user) {
        entityManager.createNamedQuery("updateStatistic")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

}
