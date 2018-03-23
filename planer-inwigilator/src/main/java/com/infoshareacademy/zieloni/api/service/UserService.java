package com.infoshareacademy.zieloni.api.service;

import com.infoshareacademy.zieloni.api.UsersDao;
import com.infoshareacademy.zieloni.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Path("/")
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    @EJB
    UsersDao usersRepositoryDao;

    public UserService() {
        //constructor
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        Collection<User> users = usersRepositoryDao.getUsersList();
        if (users.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(users).build();
    }


    @GET
    @Path("/users/{age_group}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgeGroup(@PathParam("age_group") String ageGroup) {
        List<User> group = usersRepositoryDao.getAgeGroup(ageGroup);

        if (group.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(group).build();
    }


    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("id") Integer id) {

        Optional<User> user = usersRepositoryDao.getUserById(id);
        if (!user.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user.get()).build();

    }

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserActivity(User user) {

        logger.info("aktywność uzytkownik została dodana {0}", user);
        usersRepositoryDao.addUser(user);
        return Response.ok(user).build();

    }

    @PUT
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {

        if (usersRepositoryDao.getUserById(user.getId()).isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        usersRepositoryDao.editUser(user);
        return Response.ok(user).build();
    }

}
