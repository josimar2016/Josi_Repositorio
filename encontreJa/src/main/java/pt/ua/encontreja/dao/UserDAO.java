package pt.ua.encontreja.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
public class UserDAO extends AbstractFacade<User> {
    private static final Logger log = Logger.getLogger("UserDAO");
    
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

        return (User) em.createQuery(q)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }

    public int userExistsByEmail(String email) {

        String q = "SELECT u FROM User u WHERE u.email = :email";

        int res = -1;

        res = em.createQuery(q)
                .setParameter("email", email)
                .getResultList().size();
        
        
//        System.out.println("first:" + res);

        log.setLevel(Level.ALL);
        log.log(Level.INFO, "first:{0}", res);
        
        return res;
    }

    public List<User> getUsersByType(String type) {

        String q = "SELECT u FROM User u WHERE u.type LIKE :type";

        return em.createQuery(q).setParameter("type", type).getResultList();
    }

    public List<User> getUsersByTypeWithParms(String type, int cat, String location) {

        String q = "SELECT u FROM User u, Service s, Category c \n"
                + " WHERE u.id = s.id and s.id = c.id and u.type LIKE :type and c.id = :cid and u.location = :location";

        return em.createQuery(q)
                .setParameter("type", type)
                .setParameter("cid", cat)
                .setParameter("location", location)
                .getResultList();

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
