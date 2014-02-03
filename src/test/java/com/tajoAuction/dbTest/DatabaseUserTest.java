package com.tajoAuction.dbTest;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.tajoAuction.dao.DaoInterface;
import com.tajoAuction.dao.jpa.UserJpaDao;
import com.tajoAuction.entity.UserEntity;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 18:26
 */
public class DatabaseUserTest extends TestCase{

    private Provider<EntityManager> emf = new Provider<EntityManager>() {
        @Override
        public EntityManager get() {

            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("tajoAuctionUnit");

            return emf.createEntityManager();
        }
    };


    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testCreateUser() throws Exception {

        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUsername("username");
        user.setPassword("password");

        DaoInterface userdao = new UserJpaDao(emf);
        userdao.create(user);

    }

    public void testFindUserById() throws Exception{


    }

    public void testUpdateUser() throws Exception {


    }

    public void testDeleteUser() throws Exception {


    }

    public void testGetAllUsers() throws Exception {


    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
