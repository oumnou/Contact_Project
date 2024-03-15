package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.AdminServices;
import estm.dsic.jee.rest.model.User;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/admin")

public class AdminController {

    @Inject
     AdminServices adminServices = new AdminServices();
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void validateUser(User user) {
        adminServices.validate(user);
           
    }

     
    // @PUT
    // @Consumes(MediaType.APPLICATION_JSON)
    // public void adminUser(User user) {
    //     adminServices.admin(user);
           
    // }
    
    

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(User user) {
        adminServices.delete(user);

    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        return adminServices.getAllUsers();
    }


}