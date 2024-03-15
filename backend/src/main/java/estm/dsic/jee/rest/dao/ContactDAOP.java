package estm.dsic.jee.rest.dao;

import java.util.ArrayList;
import java.util.List;

import estm.dsic.jee.rest.model.Contact;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Named
@RequestScoped
@Transactional
public class ContactDAOP implements Reposistory<Contact,Integer> {
    

    @PersistenceContext(name ="g-contacts")
    private EntityManager em;


    @Override
    public Contact create(Contact entity) {
        em.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public void delete(Contact entity) {
        Contact managedContact = em.merge(entity);
            em.remove(managedContact);
    }

    @Transactional
    @Override
    public void update(Contact entity) {
        
        Contact existingContact = find(entity);
        
        if (existingContact != null) {
            // System.out.println("update it");
            em.merge(entity);
        } else {
            // System.out.println("not update it");

        }
    }

    @Override
    public Contact find(Contact entity) {
        System.out.println(entity.getId());
        Contact foundContact = em.find(Contact.class, entity.getId());
        if (foundContact != null) {
            // System.out.println("Exist");
            return foundContact;
        }else{
            // System.out.println("not Exist");
            return null;
        }
        
    }

    @Override
    public List<Contact> getAll(int userId) {
        Query query = em.createQuery("SELECT c.id, c.nom, c.tele, c.email, c.adresse , c.userId FROM Contact c WHERE c.userId = :userId");
        query.setParameter("userId", userId);
        
        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<Contact> contacts = new ArrayList<>();
        
        for (Object[] result : results) {
            Contact contact = new Contact();
            contact.setId((int) result[0]);
            contact.setNom((String) result[1]);
            contact.setTele((String) result[2]);
            contact.setEmail((String) result[3]);
            contact.setAdresse((String) result[4]);
            contacts.add(contact);
        }
        
        return contacts;
    }

  

  
    

}