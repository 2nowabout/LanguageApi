package main.endpoints;

import main.HibernateUtil;
import main.dTO.LanguageDTO;
import main.dTO.LanguageUserDTO;
import main.helpers.RestResponseHelper;
import main.models.Language;
import main.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;
import java.util.List;

@Path("/language")
public class LanguagePoint {

    final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    @GET
    @Path("/getall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLanguages()
    {
        try {
            Transaction tx = session.beginTransaction();
            /*session.get(Language.class, "*");*/
            Query query = session.createQuery("from Language");
            List<Language> requested = query.getResultList();
            tx.commit();
            return Response.status(200).entity(requested).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @POST
    @Path("/selectlanguage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectLanguage(LanguageUserDTO dto)
    {
        try {
            Transaction tx = session.beginTransaction();
            User user = session.load(User.class, dto.getUserId());
            Language language = session.load(Language.class, dto.getLanguage().getUniqueId());
            user.setChosenLanguage(language);
            /*session.get(Language.class, "*");*/
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
