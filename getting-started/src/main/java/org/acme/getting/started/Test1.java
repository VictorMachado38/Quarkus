package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello2")
public class Test1 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Esse é o meu teste, Funcinou! Não é dinamico";
    }
}
