package com.tajoAuction.healthCheck;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.yammer.metrics.core.HealthCheck;

import javax.persistence.EntityManager;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 21:56
 */
public class DatabaseHealthCheck extends HealthCheck {

    private final Provider<EntityManager> emf;

    @Inject
    protected DatabaseHealthCheck(Provider<EntityManager> emf) {
        super("DatabaseHealthCheck");

        this.emf = emf;
    }

    @Override
    protected Result check() throws Exception {

        EntityManager em = emf.get();

        if(em.isOpen())
            return Result.healthy();
        else
            return Result.unhealthy("Cannot connect to Database");
    }
}
