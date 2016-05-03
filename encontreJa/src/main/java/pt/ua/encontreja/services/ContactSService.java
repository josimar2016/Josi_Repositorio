/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import pt.ua.encontreja.dao.ContactServiceDAO;
/**
 *
 * @author arrais
 */
@Stateless

public class ContactSService {
    
    @EJB
    ContactServiceDAO contactServiceDAO;
    
}
