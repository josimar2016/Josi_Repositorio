package pt.ua.encontreja.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pt.ua.encontreja.dao.UserDAO;
import pt.ua.encontreja.entity.User;

@Stateless
@Path("/auth")
public class AuthService {

    @EJB
    UserDAO userDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("email") String email,
            @FormParam("password") String password) throws Throwable {

        try {
            User user = userDao.getUserByAuth(email, password);

            return Response.ok(user).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
