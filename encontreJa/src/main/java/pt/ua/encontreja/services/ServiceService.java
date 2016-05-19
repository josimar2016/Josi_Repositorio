
package pt.ua.encontreja.services;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import pt.ua.encontreja.dao.ServiceDAO;


@Stateless
@Path("/service") 
public class ServiceService {
    
    @EJB
    ServiceDAO serviceDAO;
}
