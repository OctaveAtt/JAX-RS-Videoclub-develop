package com.videoclub.controller;

import com.videoclub.controller.model.creates.CreateUser;
import com.videoclub.controller.model.responses.UserResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.UserDao;
import com.videoclub.dao.entity.User;
import com.videoclub.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;


@Path("/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<UserResponse> userReponses = userService.fetchAll();
        return Response.ok(userReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateUser createUser) {
        User user = new User(createUser.getFirtname(), createUser.getLastname(), createUser.getAge(),createUser.getAddress(),createUser.getPhone(),createUser.getMail());
        UserDao userDao = DaoFactory.getUserDao();
        userDao.save(user);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        UserDao userDao = DaoFactory.getUserDao();
        userDao.delete(id);
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateUser(@PathParam("id") Long id,
                                @FormParam("firstname") String firstname,
                                @FormParam("lastname") String lastname,
                                @FormParam("age") int age,
                                @FormParam("address") String address,
                               @FormParam("phone")int phone,
                               @FormParam("mail")String mail
                               ) {

        LocalDate releasedDate = LocalDate.now(); // from releasedDateStr
        User user = new User(firstname,lastname,age,address,phone,mail);
        boolean isUpdated = userService.update(id, user);

        if (isUpdated) {
            return Response.noContent().build();
        } else {
            return Response.notModified().build();
        }

    }


}
