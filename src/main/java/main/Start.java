package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Start {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new
                ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(8020);
        ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(new APILoader()));
        context.addServlet(jerseyServlet, "/*");
        jettyServer.setHandler(context);

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
