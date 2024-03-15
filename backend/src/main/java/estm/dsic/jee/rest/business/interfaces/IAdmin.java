package estm.dsic.jee.rest.business.interfaces;
import estm.dsic.jee.rest.model.User;

import java.util.List;


public interface IAdmin {
    
    void validate(User user);
    void admin(User user);
    void delete(User user);
    List<User> getAllUsers();
  
}
