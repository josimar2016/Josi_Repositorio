/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pt.ua.encontreja.dao.ContactServiceDAO;
import pt.ua.encontreja.entity.Contact;
/**
 *
 * @author arrais
 */
@Stateless
@Path("/service") 
public class ContactSService {
    
    @EJB
    ContactServiceDAO contactServiceDAO;
    
    
     
}
