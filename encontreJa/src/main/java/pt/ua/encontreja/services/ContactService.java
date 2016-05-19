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
import javax.ws.rs.core.Response;
import pt.ua.encontreja.dao.ContactDAO;
import pt.ua.encontreja.dao.ServiceDAO;
import pt.ua.encontreja.dao.UserDAO;
import pt.ua.encontreja.entity.Contact;
import pt.ua.encontreja.entity.Service;
import pt.ua.encontreja.entity.User;

@Stateless
@Path("/contact") 
public class ContactService {
    
    @EJB
    ContactDAO contactDAO;
    
    @EJB
    UserDAO userDao;
    
    @EJB
    ServiceDAO serviceDao;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll() {
        return contactDAO.findAll();
       
    }
    
    @GET
    @Path("/{id}/{userTtype}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getContact(@PathParam("id") int id, 
            @PathParam("userTtype") String userTtype
            ) 
    {
        return contactDAO.getAllContactsToUser(id,userTtype);
    }
    
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertContact(
            @FormParam("estimatedhours") double estimatedHours,
            @FormParam("description") String description,
            @FormParam("idClient") int client,
            @FormParam("idProfessional") int professional,
            @FormParam("idService") int idService,
            @Context HttpServletResponse servletResponse) {
        
        System.out.println("idService:" + idService);
        System.out.println("professional:" + professional);
        System.out.println("client:" + client);
        System.out.println("descricao:" + description);
        System.out.println("estimatedHours:" + estimatedHours);
        User userClient = userDao.find(client);
        System.out.println("encontrei cliente:" + (userClient == null));
//        if (userClient == null) {
//            return Response.noContent();
//        }
        System.out.println("encontrei cliente:" + userClient.getEmail());
        User professionalUser = userDao.find(professional);
//        if (professionalUser == null) {
//            return Response.noContent();
//        }
        
        Service service = serviceDao.find(idService);
//        if (service == null) {
//            return Response.noContent();
//        }
        Contact contact = new Contact();
        contact.setDescription(description);
        contact.setClient(userClient);
        contact.setProfessional(professionalUser);
        contact.setService(service);
        contact.setEstimatedHours(estimatedHours);

        Date dateobj = new Date();
              
        contact.setDate(dateobj);
        contactDAO.create(contact);
        return Response.ok().build();
        
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
