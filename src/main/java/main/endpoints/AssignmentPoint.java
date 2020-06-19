package main.endpoints;

import main.HibernateUtil;
import main.dTO.SelectLessonDTO;
import main.helpers.RestResponseHelper;
import main.models.Assignment;
import main.models.Language;
import main.models.Lesson;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/assignment")
public class AssignmentPoint {

    final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAssignments(@QueryParam("id") int language)
    {
        try {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("SELECT a FROM Language a WHERE a.uniqueId = :id");
            query.setParameter("id", language);
            List<Language> requested = query.getResultList();
            List<Assignment> actual = requested.get(0).getAssignments();
            tx.commit();
            return Response.status(200).entity(actual).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @GET
    @Path("/selectAssignment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAssignment(@QueryParam("assignmentid") int assignmentid, @QueryParam("lessonid") int lessonid)
    {
        try {
            Transaction tx = session.beginTransaction();
            /*session.get(Language.class, "*");*/
            Query query = session.createQuery("SELECT a FROM Assignment a where a.uniqueId = " + assignmentid);
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
}
