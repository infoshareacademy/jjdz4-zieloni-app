package com.infoshareacademy.zieloni.servlets.service;

import com.infoshareacademy.zieloni.servlets.UsersDao;
import com.infoshareacademy.zieloni.servlets.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;

@Path("/")
public class UserService {

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    @EJB
    UsersDao usersRepositoryDao;

    public UserService() {
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
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("id") Integer id) {
        Optional<User> user = usersRepositoryDao.getUserById(id);
        if (!user.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(user.get()).build();

    }

    /*@GET
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public Response getLoginForm() {
        String html = "<form action=\"authenticate\" method=\"POST\">\n" +
                "      <input type=\"text\" name=\"username\"/><br/>\n" +
                "      <input type=\"password\" name=\"password\"/><br/>\n" +
                "      <input type=\"Submit\"/>\n" +
                "    </form>";

        return Response.ok(html).build();
    }*/


    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserActivity(User user) {

        LOG.info("aktywność uzytkownik został dodany" + user);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MM, dd, yyyy - HH:mm:ss");
        String formattedDateTime = now.format(myFormatter); // 03 01, 2017 - 12:45

        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setLogTime(formattedDateTime);
        newUser.setLogin(user.getLogin());
        newUser.setActivity(user.getActivity());

        usersRepositoryDao.addUser(newUser);
        return Response.ok(newUser).build();

    }

    @PUT
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {

        if (usersRepositoryDao.getUserById(user.getId()) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        usersRepositoryDao.editUser(user);
        return Response.ok(user).build();
    }
}
