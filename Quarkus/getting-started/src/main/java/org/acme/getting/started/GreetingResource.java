package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/quarkus")
    @Produces(MediaType.TEXT_PLAIN)
    public String NaMesmaClasse() {
        return "Na mesma classe";
    }
    //Aqui ele entra dentro do "/hello" fica ssim http://localhost:8080/hello/quarkus


}

