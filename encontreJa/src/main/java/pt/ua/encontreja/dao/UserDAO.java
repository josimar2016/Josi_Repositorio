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
import pt.ua.encontreja.entity.User;

/**
 *
 * @author arrais
 */
@Stateless
public class UserDAO extends AbstractFacade<User> {

    @PersistenceContext(unitName = "encontreja")
    private EntityManager em;

    public UserDAO() {
        super(User.class);
    }

    public List<User> getAllUser() {
        return super.findAll();
    }

     public List<User> getUsersByType(String type) {
        return em.createQuery("SELECT u FROM User u WHERE u.type LIKE :type")
                .setParameter("type", type).getResultList();
    }
     
     
    public int editContactRating(User user) {
        super.edit(user);
        return 1;
    }

    public User getUser(int id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
