package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.ContactServices;
import estm.dsic.jee.rest.model.Contact;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/contacts")
public class ContactController { 
    
    @Inject
     ContactServices ContactServices = new ContactServices();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addContact(Contact contact) {
        
        ContactServices.addContact(contact);


    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getContacts(@QueryParam("userId") int userId) {
        return ContactServices.getContacts(userId);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateContact(Contact contact) {
        ContactServices.updateContact(contact);
           
    }


    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteContact(Contact contact) {
        ContactServices.deleteContact(contact);
           
    }

}

