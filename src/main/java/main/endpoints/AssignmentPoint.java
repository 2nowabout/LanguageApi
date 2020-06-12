package main.endpoints;

import main.HibernateUtil;
import main.helpers.RestResponseHelper;
import main.models.Assignment;
import main.models.Language;
import main.models.Lesson;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/assignment")
public class AssignmentPoint {

    final Session session = HibernateUtil.getHibernateSession();

    @GET
    @Path("/getall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAssignments(int languageID)
    {
        try {
            Transaction tx = session.beginTransaction();
            /*session.get(Language.class, "*");*/
            Query query = session.createQuery("SELECT * FROM Assignment where languageId = " + languageID);
            List<Assignment> requested = query.getResultList();
            tx.commit();
            return Response.status(200).entity(requested).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @GET
    @Path("/selectAssignment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAssignment(int assignmentID)
    {
        try {
            Transaction tx = session.beginTransaction();
            /*session.get(Language.class, "*");*/
            Query query = session.createQuery("SELECT * FROM Lesson where assignmentId = " + assignmentID);
            List<Lesson> requested = query.getResultList();
            tx.commit();
            return Response.status(200).entity(requested).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
    }
}
