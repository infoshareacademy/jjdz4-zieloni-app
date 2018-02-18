package com.infoshareacademy.zieloni.registration;
import com.infoshareacademy.zieloni.registration.model.Roles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RolesDaoImpl implements RolesDao  {


    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager1;


    @Override
    public Roles role_group(String login) {
        return (Roles) entityManager1.createNamedQuery("role_group")
                .setParameter("login", login)
                .getSingleResult();
        //return null;
    }
}
