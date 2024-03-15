package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.UserServices;
import estm.dsic.jee.rest.model.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserController {

  @Inject
    UserServices userServices = new UserServices();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User signup(User user) {
       userServices.signup(user);
       return user;

    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(User user) {
      User u = userServices.authentification(user);
      return u;
          
    }



}
