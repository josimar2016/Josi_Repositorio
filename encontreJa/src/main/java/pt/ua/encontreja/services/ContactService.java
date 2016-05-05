/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import pt.ua.encontreja.dao.ContactDAO;
import pt.ua.encontreja.entity.Contact;
/**
 *
 * @author arrais
 */
@Stateless

public class ContactService {
    
    @EJB
    ContactDAO contactDAO;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll() {
        return contactDAO.findAll();
       
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getContact(@PathParam("id") int id) {
        return contactDAO.getContact(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insertContact(
            @FormParam("estimatedHours") double estimatedHours,
            @FormParam("data") String data,
            @FormParam("descricao") String descricao,
            @Context HttpServletResponse servletResponse) throws ParseException{
        
        Contact contact = new Contact();
        contact.setDescription(descricao);
        contact.setEstimatedHours(estimatedHours);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date data1 = null;
        data1 = df.parse(data);
                
        contact.setDate(data1);
        //TO-DO
        return "sucess";    
        
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String editContact(
            @PathParam("id") int id,
            @FormParam("estimatedHours") double estimatedHours,
            @FormParam("data") String data,
            @FormParam("descricao") String descricao,
            @Context HttpServletResponse servletResponse) throws ParseException{
        
        Contact contact = contactDAO.find(id);
        
         if(contact == null)
            return String.valueOf(-1);
         
        contact.setDescription(descricao);
        contact.setEstimatedHours(estimatedHours);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date data1 = null;
        data1 = df.parse(data);
                
        contact.setDate(data1);
         
         return "Sucess";
        
    }
}
