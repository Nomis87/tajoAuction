package com.tajoAuction.config;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;

/**
 * User: Tobias
 * Date: 31.01.14
 * Time: 17:10
 */
public class TajoAuctionConfiguration extends Configuration{

    @Valid
    private DatabaseConfiguration database;

    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }
}
