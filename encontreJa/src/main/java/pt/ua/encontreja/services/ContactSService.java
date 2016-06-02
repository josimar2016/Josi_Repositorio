package pt.ua.encontreja.services;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pt.ua.encontreja.dao.ContactDAO;
import pt.ua.encontreja.dao.ContactServiceDAO;
import pt.ua.encontreja.dao.UserDAO;
import pt.ua.encontreja.entity.Contact;
import pt.ua.encontreja.entity.ContactService;
import pt.ua.encontreja.entity.User;

@Stateless
@Path("/contactService")
public class ContactSService {

    @EJB
    ContactServiceDAO contactServiceDAO;

    @EJB
    UserDAO userDao;

    @EJB
    ContactDAO contactDAO;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertContact(
            @FormParam("hours") double hours,
            @FormParam("description") String description,
            @FormParam("contactid") int idContact,
            @FormParam("userid") int professional) {

        ContactService cService = new ContactService();
        cService.setHours(hours);
        cService.setDescription(description);

        User professionalUser = userDao.find(professional);

        Contact contact = contactDAO.find(idContact);

        cService.setUser(professionalUser);
        cService.setContact(contact);

        Date dateobj = new Date();
        cService.setDate(dateobj);
        contactServiceDAO.create(cService);
        
        return Response.ok().build();

    }
}
