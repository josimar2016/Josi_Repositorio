/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.dao;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.Rating;
/**
 *
 * @author arrais
 */
public class RatingDAO extends AbstractFacade<Rating>{

    @PersistenceContext(unitName = "encontreja")
    private EntityManager em;

    @EJB
    UserDAO userDAO;
    
    @EJB
    ServiceDAO serviceDAO;
    
    
    public RatingDAO(Class<Rating> entityClass) {
        super(entityClass);
    }
    
    public List<Rating> getAllRating(){
        return super.findAll();
    }
    
    public int editContactRating(Rating rating){
        super.edit(rating);
        return 1;
    }
    
    public Rating getContactRating(int id){
        return super.find(id);
    }
   
  
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
