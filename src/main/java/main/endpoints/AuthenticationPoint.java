package main.endpoints;

import main.HibernateUtil;
import main.dTO.LanguageUserDTO;
import main.dTO.UserDTO;
import main.helpers.RestResponseHelper;
import main.logic.Hashing;
import main.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthenticationPoint {

    final Session session = HibernateUtil.getHibernateSession();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(UserDTO dto)
    {
        try {
            Transaction tx = session.beginTransaction();
            User receivedUser;
            if(dto.getEmail().contains("@")) {
                receivedUser = session.load(User.class, dto.getEmail());
            }
            else {
                receivedUser = session.load(User.class, dto.getUsername());
            }
            tx.commit();
            if (Hashing.checkPassword(dto.getPassword(), receivedUser.getPassword())) {
                return Response.status(200).entity(receivedUser).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "*").build();
            }
            return Response.status(403).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(UserDTO dto)
    {
        try {
            Transaction tx = session.beginTransaction();
            User newUser = new User();
            newUser.setEmail(dto.getEmail());
            newUser.setUsername(dto.getUsername());
            newUser.setPassword(Hashing.hashPassword(dto.getPassword()));
            newUser.setPictureLocation(dto.getPictureLocation());
            session.save(newUser);
            tx.commit();
            return Response.status(200).entity(RestResponseHelper.getSuccesResponse()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
    }
}
