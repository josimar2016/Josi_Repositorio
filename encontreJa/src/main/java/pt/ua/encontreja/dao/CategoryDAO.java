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
import pt.ua.encontreja.entity.*;
/**
 *
 * @author arrais
 */
public class CategoryDAO extends AbstractFacade<Category> {

    
   @PersistenceContext(unitName = "encontreja")
   private EntityManager em;
    
   @EJB
   ServiceDAO serviceDAO;
  
           
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

 
    
    
    

