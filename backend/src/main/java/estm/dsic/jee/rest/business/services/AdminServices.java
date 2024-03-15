package estm.dsic.jee.rest.business.services;

import java.util.List;
import java.io.Serializable;

import estm.dsic.jee.rest.business.interfaces.IAdmin;
import estm.dsic.jee.rest.dao.UserDAOP;
import estm.dsic.jee.rest.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/**
 * AdminServices
 */

@Named
@RequestScoped
public class AdminServices implements IAdmin, Serializable{

    @Inject
     UserDAOP userDAO = new UserDAOP(); 
    
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
       return userDAO.getAll(0);
    }

    @Override
    public void validate(User user) {
       userDAO.validateUser(user);;
    }

    @Override
    public void admin(User user) {
       userDAO.adminUser(user);;
    }


  

}