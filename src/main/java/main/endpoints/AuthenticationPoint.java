package main.endpoints;

import main.HibernateUtil;
import main.dTO.LanguageUserDTO;
import main.dTO.LoginDTO;
import main.dTO.UserDTO;
import main.helpers.RestResponseHelper;
import main.logic.Hashing;
import main.models.Language;
import main.models.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/auth")
public class AuthenticationPoint {

    final Session session = HibernateUtil.getHibernateSession();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(LoginDTO dto)
    {
        try {
            Transaction tx = session.beginTransaction();
            User actualUser = null;
            Query query;
            if(dto.getEmail().contains("@")) {
                query = session.createQuery("FROM User user WHERE user.email =  :email");
                query.setParameter("email", dto.getEmail());
            }
            else {
                query = session.createQuery("FROM User user WHERE user.username =  :username");
                query.setParameter("username", dto.getEmail());
            }
            List<User> users = query.getResultList();
            for (User user: users) {
                if (Hashing.checkPassword(dto.getPassword(), user.getPassword())) {
                    actualUser = user;
                }
            }
            tx.commit();
            if (actualUser != null) {
                if (actualUser.getChosenLanguage() == null) {
                    Language language = new Language();
                    language.setUniqueId(0);
                    actualUser.setChosenLanguage(language);
                }
                return Response.status(200).entity(actualUser).header("Access-Control-Allow-Origin", "*").build();
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
