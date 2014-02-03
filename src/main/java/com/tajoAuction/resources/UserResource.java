package com.tajoAuction.resources;

import com.google.inject.Inject;
import com.tajoAuction.dao.jpa.UserJpaDao;
import com.tajoAuction.entity.UserEntity;
import com.yammer.dropwizard.jersey.params.IntParam;
import com.yammer.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * User: Tobias
 * Date: 31.01.14
 * Time: 18:32
 */

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserJpaDao userDao;

    @Inject
    public UserResource(UserJpaDao userDao) {
        this.userDao = userDao;
    }


    @POST
    @Timed
    @Path("/create")
    public Response createUser(@Valid UserEntity user){

        userDao.create(user);

        //TODO Build Response from User create with Status
        return Response.noContent().build();
    }

    @GET
    @Timed
    @Path("/find/{userId}")
    public UserEntity findUserById(@PathParam("userId") IntParam userId){

        int id = (int) userId.get();

        return userDao.getObjectById(id);
    }

    @GET
    @Timed
    @Path("/all")
    public List<UserEntity> getAllUsers(){

        return userDao.getAllObjects();
    }

    @DELETE
    @Timed
    @Path("/delete/{userId}")
    public Response deleteUserById(@PathParam("userId") IntParam userId){

        userDao.deleteObjectById(userId.get());

        //TODO Build Response from User delete with Status
        return Response.noContent().build();
    }


}
