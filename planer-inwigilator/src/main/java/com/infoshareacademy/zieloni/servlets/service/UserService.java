package com.infoshareacademy.zieloni.servlets.service;

import com.infoshareacademy.zieloni.servlets.UsersDao;
import com.infoshareacademy.zieloni.servlets.model.User;
import com.infoshareacademy.zieloni.servlets.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;
import java.util.Optional;

@Path("/")
public class UserService {

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    @EJB
    UsersDao usersRepositoryDao;

    @Inject
    private UserStore userStore;

    public UserService() {
    }


    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

       /* Collection<User> users = userStore.getBase().values();
        if (users.isEmpty()) {
            return Response.noContent().build();
        }*/
        Collection<User> users =  usersRepositoryDao.getUsersList();
        if (users.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(users).build();
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("id") Integer id) {
        Optional<User> user = userStore.findById(id);
        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        }

        //return Response.status(404).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public Response getLoginForm() {
        String html = "<form action=\"authenticate\" method=\"POST\">\n" +
                "      <input type=\"text\" name=\"username\"/><br/>\n" +
                "      <input type=\"password\" name=\"password\"/><br/>\n" +
                "      <input type=\"Submit\"/>\n" +
                "    </form>";

        return Response.ok(html).build();
    }


    /*@POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {

        int newId = userStore.getNewId();
        LOG.info("New ID: {}", newId);

        userStore.add(new User(user.getName(),
                user.getSurname(),
                newId
        ));

        return getUsers();
    }*/

    @PUT
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {

        if (userStore.getBase().containsKey(user.getId())) {
            userStore.getBase().put(user.getId(), user);
            return Response.ok(user).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@QueryParam("id") Integer id) {

        if (userStore.getBase().containsKey(id)) {
            userStore.getBase().remove(id);
            return getUsers();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
