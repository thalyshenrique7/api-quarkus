package com.devthalys;

import com.devthalys.models.UserModel;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> list() {
        return UserModel.listAll();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void newUser() {
        UserModel user = new UserModel();
        user.name = "Clay";
        user.age = 39;
        user.persist();
    }
}
