package pt.ua.encontreja.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.Contact;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ContactDAO extends AbstractFacade<Contact> {

    private static final Logger LOGGER = Logger.getLogger("ContactDAO");

    @PersistenceContext(unitName = "encontreja")
    private EntityManager em;

    public ContactDAO() {
        super(Contact.class);
    }

    public ContactDAO(Class<Contact> entityClass) {
        super(entityClass);
    }

    public List<Contact> getAllContact() {
        return super.findAll();
    }

    public List getAllContactsToUser(int id, String userType) {

        //String q = "SELECT c FROM Contact c , User u WHERE u.id = :id and u.type = :userType and u.id = c.professional";
        String q ;
        if (userType.toLowerCase().contains("professional")) {
            q = "SELECT c FROM Contact c INNER JOIN c.professional u where u.id = :id and u.type = :userType";
        }
        else {
            q = "SELECT c FROM Contact c INNER JOIN c.client u where u.id = :id and u.type = :userType";
        }

        LOGGER.setLevel(Level.ALL);
        LOGGER.log(Level.INFO, "userType:{0}", userType);
        LOGGER.log(Level.INFO, "userID:{0}", id);
        LOGGER.log(Level.INFO, "q:{0}", q);
        return em.createQuery(q).setParameter("id", id)
                .setParameter("userType", userType)
                .getResultList();

    }

    public int editContact(Contact contact) {
        super.edit(contact);
        return 1;
    }

    public Contact getContact(int id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
