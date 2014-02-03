package com.tajoAuction.dao.jpa;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.tajoAuction.dao.DaoInterface;
import com.tajoAuction.entity.BidEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 16:28
 */
public class BidJpaDao implements DaoInterface<BidEntity> {


    private final Provider<EntityManager> emf;

    @Inject
    protected BidJpaDao(Provider<EntityManager> emf) {
        this.emf = emf;
    }


    @Override
    public void create(BidEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();

    }

    @Override
    public BidEntity getObjectById(int id) {

        EntityManager em = emf.get();
        BidEntity ue = em.find(BidEntity.class, id);

        return ue;
    }

    @Override
    public void update(BidEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void deleteObjectById(int id) {

        EntityManager em = emf.get();

        BidEntity bidEntity = getObjectById(id);
        if(bidEntity != null){
            em.getTransaction().begin();
            em.remove(bidEntity);
            em.getTransaction().commit();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BidEntity> getAllObjects() {

        EntityManager em = emf.get();
        Query query = em.createQuery("SELECT u FROM BidEntity u");

        return query.getResultList();

    }
}
