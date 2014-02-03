package com.tajoAuction.dao.jpa;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.tajoAuction.dao.DaoInterface;
import com.tajoAuction.entity.AppointmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 16:57
 */
public class AppointmentJpaDao implements DaoInterface<AppointmentEntity> {


    private final Provider<EntityManager> emf;

    @Inject
    protected AppointmentJpaDao(Provider<EntityManager> emf) {
        this.emf = emf;
    }


    @Override
    public void create(AppointmentEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public AppointmentEntity getObjectById(int id) {

        EntityManager em = emf.get();
        AppointmentEntity ue = em.find(AppointmentEntity.class, 1);

        return ue;
    }

    @Override
    public void update(AppointmentEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();

    }

    @Override
    public void deleteObjectById(int id) {

        EntityManager em = emf.get();

        AppointmentEntity appointmentEntity = getObjectById(id);
        if(appointmentEntity != null){
            em.getTransaction().begin();
            em.remove(appointmentEntity);
            em.getTransaction().commit();
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AppointmentEntity> getAllObjects() {

        EntityManager em = emf.get();
        Query query = em.createQuery("SELECT u FROM AppointmentEntity u");

        return query.getResultList();
    }
}
