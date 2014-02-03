package com.tajoAuction.dao;

import java.util.List;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 15:32
 *
 * Abstract DaoInterface for CRUD Methods
 *
 */
public interface DaoInterface<K> {

    //Create a Entity Object
    public void create(K object);

    //Get Entity Object by Id
    public K getObjectById(int id);

    //Update Entity Object
    public void update(K object);

    //Delete Entity Object
    public void deleteObjectById(int id);

    //Get all Objects
    public List<K> getAllObjects();

}
