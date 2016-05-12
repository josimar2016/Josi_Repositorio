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
import javax.ws.rs.QueryParam;
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

    public List<User> GetUsersByType(String type) {

        String q = "SELECT u FROM User u WHERE u.type LIKE :type";
        
        List<User> results = em.createQuery(q)
                .setParameter("type", type).getResultList();
        return results;
    }
      public List<User> GetUsersByTypeWithParms(String type, int cat, String location) {
        
        String q = "SELECT u FROM User u, Service s, Category c \n" +
" WHERE u.id = s.id and s.id = c.id and u.type LIKE :type and c.id = :cid and u.location = :location";
 
        List<User> results = em.createQuery(q)
                .setParameter("type", type)
                .setParameter("cid", cat)
                .setParameter("location", location)
                .getResultList();
        return results;
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
