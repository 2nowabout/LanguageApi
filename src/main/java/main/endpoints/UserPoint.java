package main.endpoints;

import main.dTO.LanguageUserDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserPoint {

    @POST
    @Path("/selectlanguage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectLanguage(LanguageUserDTO dto)
    {
        return null;
    }
}
