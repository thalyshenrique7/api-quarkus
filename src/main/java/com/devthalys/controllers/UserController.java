package com.devthalys.controllers;

import com.devthalys.models.UserModel;
import com.devthalys.services.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;

@Path(value = "/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<UserModel> findAll(){
        return userService.findAll();
    }

    @GET
    @Path(value = "/{id}")
    public UserModel findById(@PathParam("id") Long id){
        return userService.findById(id);
    }

    @Transactional
    @POST
    public void save(UserModel user){
        userService.save(user);
    }

    @Transactional
    @DELETE
    @Path(value = "/delete/{id}")
    public void delete(@PathParam("id") Long id){
        UserModel user = userService.findById(id);
        if(user == null){
            throw new RuntimeException("User not found.");
        }
        userService.delete(user);
    }
}
