package com.tajoAuction.dao.jpa;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.tajoAuction.dao.DaoInterface;
import com.tajoAuction.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 15:48
 */
public class UserJpaDao  implements DaoInterface<UserEntity> {


    private final Provider<EntityManager> emf;

    @Inject
    public UserJpaDao(Provider<EntityManager> emf) {
        this.emf = emf;
    }

    @Override
    public void create(UserEntity object) {

        EntityManager em =  emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();

        System.out.println("User Create wird aufgerufen");
    }

    @Override
    public UserEntity getObjectById(int id) {

        EntityManager em = emf.get();
        UserEntity ue = em.find(UserEntity.class, id);

        System.out.println("User GetObjectById: "+id);
        return ue;
    }

    @Override
    public void update(UserEntity object) {

        EntityManager em = emf.get();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();

        System.out.println("User Update wird aufgerufen");
    }

    @Override
    public void deleteObjectById(int id) {

        EntityManager em = emf.get();

        System.out.println("User delete wird aufgerufen");

        UserEntity userEntity = getObjectById(id);
        if(userEntity != null){
            em.getTransaction().begin();
            em.remove(userEntity);
            em.getTransaction().commit();
        }

    }

    @Override
    public List<UserEntity> getAllObjects() {

        EntityManager em = emf.get();
        Query query = em.createQuery("SELECT u FROM UserEntity u");

        System.out.println("User All wird aufgerufen");

        return query.getResultList();
    }
}
