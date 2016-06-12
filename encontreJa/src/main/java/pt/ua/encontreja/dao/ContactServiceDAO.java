
package pt.ua.encontreja.dao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.ContactService;

@Stateless
public class ContactServiceDAO extends AbstractFacade<ContactService>{

    @PersistenceContext(unitName = "encontreja")
     private EntityManager em;

    public ContactServiceDAO() {
         super(ContactService.class);
    }
    
    public ContactServiceDAO(Class<ContactService> entityClass) {
        super(entityClass);
    }
    
    public List<ContactService> getAllContactService(){
        return super.findAll();
    }
    
    public int editContactService(ContactService contactService){
        super.edit(contactService);
        return 1;
    }
    
    public ContactService getContactService(int id){
        return super.find(id);
    }
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
