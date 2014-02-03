package com.tajoAuction;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.tajoAuction.config.DatabaseConfiguration;
import com.tajoAuction.config.TajoAuctionConfiguration;
import com.tajoAuction.healthCheck.DatabaseHealthCheck;
import com.tajoAuction.resources.AppointmentResource;
import com.tajoAuction.resources.AuctionResource;
import com.tajoAuction.resources.BidResource;
import com.tajoAuction.resources.UserResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import java.util.Properties;

/**
 * User: Tobias
 * Date: 31.01.14
 * Time: 17:11
 */
public class TajoAuctionService extends Service<TajoAuctionConfiguration>{


    public static void main(String[] args) throws Exception{


        new TajoAuctionService().run(new String[]{"server","configuration.yml"});

    }

    @Override
    public void initialize(Bootstrap<TajoAuctionConfiguration> bootstrap) {

        bootstrap.setName("tajoAuction");

    }

    @Override
    public void run(TajoAuctionConfiguration conf, Environment env) throws Exception {

        //Google Guice for Dependency Injection
        Injector injector = createInjector(conf);

        //Register Health Checks
        env.addHealthCheck(injector.getInstance(DatabaseHealthCheck.class));

        //Register Filter
        env.addFilter(injector.getInstance(PersistFilter.class), "/*");

        //Register Resources
        env.addResource(injector.getInstance(UserResource.class));
        env.addResource(injector.getInstance(AppointmentResource.class));
        env.addResource(injector.getInstance(AuctionResource.class));
        env.addResource(injector.getInstance(BidResource.class));

    }

    /**
     *
     * Separate Method to Create a Google Guice Injector
     * and bind Configurations
     *
     * @param conf
     * @return
     */
    private Injector createInjector(final TajoAuctionConfiguration conf){

        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
               bind(TajoAuctionConfiguration.class).toInstance(conf);
            }
        }, createJpaPersistModule(conf.getDatabase()));

    }

    /**
     *
     * Separate Method to idealize Jpa Database Connection from configuration.yml
     *
     * @param conf
     * @return
     */
    private JpaPersistModule createJpaPersistModule(DatabaseConfiguration conf) {
        Properties props = new Properties();
        props.put("javax.persistence.jdbc.url", conf.getUrl());
        props.put("javax.persistence.jdbc.user", conf.getUser());
        props.put("javax.persistence.jdbc.password", conf.getPassword());
        props.put("javax.persistence.jdbc.driver", conf.getDriverClass());
        JpaPersistModule jpaModule = new JpaPersistModule("tajoAuctionUnit");
        jpaModule.properties(props);
        return jpaModule;
    }

}
