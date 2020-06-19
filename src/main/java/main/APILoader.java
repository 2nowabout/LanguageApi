package main;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class APILoader extends ResourceConfig {
    public APILoader() {
        packages("main.endpoints");
        register(CorsProvider.class);
    }
}
