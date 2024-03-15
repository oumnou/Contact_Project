package estm.dsic.jee.rest.business.services;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.rest.business.interfaces.IContact;
import estm.dsic.jee.rest.dao.ContactDAOP;
import estm.dsic.jee.rest.model.Contact;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/**
 * ContactServices
 */

@Named
@RequestScoped
public class ContactServices implements IContact, Serializable{

    @Inject
     ContactDAOP contactDAO = new ContactDAOP();

    @Override
    public void addContact(Contact contact) {
        if (isValidEmail(contact.getEmail())) {
            contactDAO.create(contact) ;
        }
        
    }

    @Override
    public void deleteContact(Contact contact) {
        contactDAO.delete(contact) ;
    }

    @Override
    public void updateContact(Contact contact) {
       contactDAO.update(contact) ;
    }

    @Override
    public List<Contact> getContacts(int id) {
        return contactDAO.getAll(id);
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
    
}
