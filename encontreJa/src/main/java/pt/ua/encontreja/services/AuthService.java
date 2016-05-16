/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;

/**
 *
 * @author mezca
 */
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pt.ua.encontreja.dao.UserDAO;
import pt.ua.encontreja.entity.User;

/**
 * @author Tiago Coelho
 */
@Stateless
@Path("/auth")
public class AuthService {

    @EJB
    UserDAO userDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("email") String email,
            @FormParam("password") String password) {

        try {
            User user = userDao.getUserByAuth(email, password);

            return Response.ok(user).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
