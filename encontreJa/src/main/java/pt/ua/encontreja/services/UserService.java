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
import pt.ua.encontreja.dao.ServiceDAO;
import pt.ua.encontreja.entity.Service;

/**
 *
 * @author arrais
 */
@Stateless
@Path("/user") 
public class UserService {
    
    @EJB
    UserDAO userDao;
    
    @EJB
    ServiceDAO serviceDAO;
    
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
           
            @FormParam("nome") String nome,
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("type") String type,
            @FormParam("phone") int phone,
            @FormParam("location") String location,
            @FormParam("description") String descripton,
            @FormParam("feePrice") double feePrice,
            @FormParam("hourPrice") double hourPrice,
            @FormParam("service") String serviceName,
            @FormParam("userImg") String userImg,
            
            @Context HttpServletResponse servletResponse){
            System.out.println("creating new user");
            System.out.println("nome:" + nome);
            System.out.println("email:" + email);
            System.out.println("password:" + password);
            System.out.println("type:" + type);
            System.out.println("phone:" + phone);
            System.out.println("location:" + location);
            System.out.println("creating new Service:");
            System.out.println("nome:" + serviceName);
            System.out.println("descripton:" + descripton);
            System.out.println("feePrice:" + feePrice);
            System.out.println("hourPrice:" + hourPrice);
            
            User user = new User();
           
            
            user.setName(nome);
            user.setEmail(email);
            user.setPassWord(password);
            user.setPhone(phone);
            user.setLocation(location);
            user.setUserImg(userImg);
            user.setType(type);
            
         
            userDao.create(user);
          
            
            
            if(type == "professional"){ 
                Service service = new Service();
                
                service.setTitle(serviceName);
                service.setDescription(descripton);
                service.setFeePrice(feePrice);
                service.setHourPrice(hourPrice);

                user.addService(service);
                serviceDAO.create(service);
             }

            return "1";                  
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
            @FormParam("userImg") String userImg,
            @Context HttpServletResponse servletResponse){
        
            User user = new User();
            user.setId(id_user);
            user.setName(nome);
            user.setEmail(email);
            user.setPassWord(password);
            user.setPhone(phone);
            user.setLocation(location);
            user.setType(type);
            user.setUserImg(userImg);
            
            userDao.create(user);
            return "1";
                    
    }
    
}
