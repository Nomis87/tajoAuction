package com.tajoAuction.dao.jpa;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.tajoAuction.dao.DaoInterface;
import com.tajoAuction.entity.AuctionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 16:05
 */
public class AuctionJpaDao implements DaoInterface<AuctionEntity>{

    private final Provider<EntityManager> emf;

    @Inject
    public AuctionJpaDao(Provider<EntityManager> emf) {
        this.emf = emf;
    }

    @Override
    public void create(AuctionEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();

    }

    @Override
    public AuctionEntity getObjectById(int id) {

        EntityManager em = emf.get();
        AuctionEntity ue = em.find(AuctionEntity.class, id);

        return ue;
    }

    @Override
    public void update(AuctionEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void deleteObjectById(int id) {

        EntityManager em = emf.get();

        AuctionEntity auctionEntity = getObjectById(id);
        if(auctionEntity != null){
            em.getTransaction().begin();
            em.remove(auctionEntity);
            em.getTransaction().commit();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AuctionEntity> getAllObjects() {

        EntityManager em = emf.get();
        Query query = em.createQuery("SELECT u FROM AuctionEntity u");

        return query.getResultList();

    }
}
