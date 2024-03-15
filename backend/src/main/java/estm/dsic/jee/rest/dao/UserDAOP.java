package estm.dsic.jee.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import estm.dsic.jee.rest.model.Contact;
import estm.dsic.jee.rest.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Named
@RequestScoped
@Transactional
public class UserDAOP implements Reposistory<User,Integer> {

    @PersistenceContext(name="g-contacts")
    private EntityManager em;

    //Search 
    public User searchUser(int id) {

        User u = em.find(User.class, id);
        System.out.println(u);
        return u;
    
    }

    // Validate User
    public void adminUser(User user) {
        
        User userS = searchUser(user.getId());
        System.out.println(userS);
            
        
        // Set the isAdmin flag to true
        userS.setIsAdmin(!userS.getIsAdmin());
    
        // Update the user in the database
        em.merge(user);
    
    }

    public void validateUser(User user) {
        
        User userS = find(user);
        System.out.println(userS);
            
        
        // Set the isAdmin flag to true
        userS.setIsAdmin(!userS.getIsValid());
    
        // Update the user in the database
        em.merge(user);
    
    }

    @Override
    public User create(User entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void delete(User entity) {
        Set<Contact> contacts = entity.getContacts();
    
        for (Contact contact : contacts) {
            em.remove(contact);
        }
        
        em.remove(entity); 
    }

 
    @Override
    public User find(User entity) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password", User.class);
        query.setParameter("login", entity.getLogin());
        query.setParameter("password", entity.getPassword());

        try {
            User u = query.getSingleResult();
            return u;

        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> getAll(int id) {
       
            Query query = em.createQuery("SELECT u.id, u.login FROM User u ");
            
    
            
            @SuppressWarnings("unchecked")
            List<Object[]> results = query.getResultList();
            List<User> users = new ArrayList<>();
            
            for (Object[] result : results) {
                User user = new User();
                user.setId((int) result[0]);
                user.setLogin((String) result[1]);
                
                users.add(user);
            }
            
            return users;
    }

    @Override
    public void update(User entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
