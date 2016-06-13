
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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import pt.ua.encontreja.dao.CategoryDAO;
import pt.ua.encontreja.dao.ServiceDAO;
import pt.ua.encontreja.entity.Category;
import pt.ua.encontreja.entity.Service;


@Stateless
@Path("/user")
public class UserService {

    @EJB
    UserDAO userDao;

    @EJB
    CategoryDAO categoryDAO;

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
    public List<User> getUsersbyType(@PathParam("type") String type, @QueryParam("c") int cat, @QueryParam("l") String location) {

        if (cat > 0 && location != null) {

            return userDao.getUsersByTypeWithParms(type, cat, location);
        } else {
            return userDao.getUsersByType(type);
        }

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
    public User insertCUser(
            @FormParam("nome") String nome,
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("type") String type,
            @FormParam("phone") int phone,
            @FormParam("location") String location,
            @FormParam("description") String descripton,
            @FormParam("feePrice") double feePrice,
            @FormParam("hourPrice") double hourPrice,
            @FormParam("category[id]") int category,
            @FormParam("userImg") String userImg) {

        if (userDao.userExistsByEmail(email) > 0) {
            return null;
        }

        User user = new User();

        user.setName(nome);
        user.setEmail(email);
        user.setPassWord(password);
        user.setPhone(phone);
        user.setLocation(location);
        user.setUserImg(userImg);
        user.setType(type);

        userDao.create(user);
        if (type.toLowerCase().contains("professional")) {

            Service service = new Service();

            service.setDescription(descripton);
            service.setFeePrice(feePrice);
            service.setUser(user);

            service.setHourPrice(hourPrice);
            Category cat = categoryDAO.find(category);
            service.setTitle(cat.getName());
            service.setCategory(cat);
            user.addService(service);
            serviceDAO.create(service);
        }

        return user;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void editCUser(
            @PathParam("id") int id,
            @FormParam("nome") String nome,
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("phone") int phone,
            @FormParam("location") String location,
            @FormParam("description") String descripton,
            @FormParam("feePrice") double feePrice,
            @FormParam("hourPrice") double hourPrice,
            @FormParam("selectedCategory[id]") int category) {

     
        User user = userDao.find(id);
       
        user.setName(nome);
        user.setEmail(email);
        if (password.length() >0) {
            user.setPassWord(password);
        }
        user.setPhone(phone);
        user.setLocation(location);
        
        if (user.getType().toLowerCase().contains("professional")) {
         
            Service service = user.getServiceList().get(0);

            service.setDescription(descripton);
            service.setFeePrice(feePrice);
            service.setUser(user);
            service.setHourPrice(hourPrice);

            Category cat = categoryDAO.find(category);

            service.setTitle(cat.getName());
            service.setCategory(cat);
            user.addService(service);

            serviceDAO.edit(service);
        }

        userDao.edit(user);

    }

}
