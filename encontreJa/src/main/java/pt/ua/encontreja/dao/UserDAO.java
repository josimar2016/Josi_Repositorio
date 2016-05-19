
package pt.ua.encontreja.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.User;


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

    public User getUserByAuth(String email, String password) {

        String q = "SELECT u FROM User u WHERE u.email = :email and u.password = :password";

        User user = (User) em.createQuery(q)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        return (user);
    }
      public int userExistsByEmail(String email) {

        String q = "SELECT u FROM User u WHERE u.email = :email";
        
        int res = -1;
    
        res = em.createQuery(q)
            .setParameter("email", email)
            .getResultList().size();

          
       System.out.println("first:" + res);
        return (res);
    }


    public List<User> GetUsersByType(String type) {

        String q = "SELECT u FROM User u WHERE u.type LIKE :type";

        List<User> results = em.createQuery(q)
                .setParameter("type", type).getResultList();
        return results;
    }

    public List<User> GetUsersByTypeWithParms(String type, int cat, String location) {

        String q = "SELECT u FROM User u, Service s, Category c \n"
                + " WHERE u.id = s.id and s.id = c.id and u.type LIKE :type and c.id = :cid and u.location = :location";

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
