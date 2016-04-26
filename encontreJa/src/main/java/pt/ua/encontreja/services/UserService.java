/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;
import java.util.List;
import pt.ua.encontreja.dao.UserDAO;
import pt.ua.encontreja.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author arrais
 */
@Stateless
@Path("/user") 
public class UserService {
    
    @EJB
    UserDAO userDao;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return userDao.findAll();
    }
    
    @GET
    @Path("/type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersbyType(@PathParam("type") String type) {
        return userDao.GetUsersByType(type);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id) {
        return userDao.getUser(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insertCUser(
            @FormParam("id_user") int id_user,
            @FormParam("nome") String nome,
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("type") String type,
            @FormParam("phone") int phone,
            @FormParam("location") String location,
            @Context HttpServletResponse servletResponse){
        
            User user = new User();
            user.setId(id_user);
            user.setName(nome);
            user.setEmail(email);
            user.setPassWord(password);
            user.setPhone(phone);
            user.setLocation(location);
            user.setType(type);
            
            //TO-DO
            return "sucess";                  
    }
    
    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String editCUser(
            @FormParam("id_user") int id_user,
            @FormParam("nome") String nome,
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("type") String type,
            @FormParam("phone") int phone,
            @FormParam("location") String location,
            @Context HttpServletResponse servletResponse){
        
            User user = new User();
            user.setId(id_user);
            user.setName(nome);
            user.setEmail(email);
            user.setPassWord(password);
            user.setPhone(phone);
            user.setLocation(location);
            user.setType(type);
            
            //TO-DO
            return "sucess";
                    
    }
    
}
