/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.Contact;

/**
 *
 * @author arrais
 */
@Stateless
public class ContactDAO extends AbstractFacade<Contact> {

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
    
    public List getAllContactsToUser(int id,String userType) {

        String q = "SELECT c FROM Contact c , User u WHERE u.id = :id and u.type = :userType";

        System.out.println("userType:" + userType);
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
