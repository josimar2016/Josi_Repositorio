
package pt.ua.encontreja.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.*;

@Stateless
public class CategoryDAO extends AbstractFacade<Category> {

    
   @PersistenceContext(unitName = "encontreja")
   private EntityManager em;

    public CategoryDAO() {
         super(Category.class);
    }
              
    public CategoryDAO(Class<Category> entityClass) {
        super(entityClass);
    }

    public List<Category> getAllCategory(){
        return super.findAll();
    }
    
    public int editService(Category category){
        super.edit(category);
        return 1;
    }
    
    public Category getService(int id){
        return super.find(id);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
        
    }
    
 }

 
    
    
    

