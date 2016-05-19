
package pt.ua.encontreja.services;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import pt.ua.encontreja.dao.RatingDAO;

@Stateless
@Path("/rating") 
public class RatingService {
    
    @EJB
    RatingDAO ratingDAO;
    
    
}
