package estm.dsic.jee.rest.business.interfaces;

import java.util.List;
import estm.dsic.jee.rest.model.Contact;


public interface IContact {
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    void updateContact(Contact contact);
    List<Contact> getContacts(int id);

}
