/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;
import javax.ejb.EJB;
import pt.ua.encontreja.dao.ServiceDAO;

/**
 *
 * @author arrais
 */
public class ServiceService {
    
    @EJB
    ServiceDAO serviceDAO;
}
