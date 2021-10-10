package cerveja;



import io.quarkus.security.Authenticated;
import org.codehaus.groovy.syntax.TokenUtil;
import org.junit.jupiter.api.BeforeEach;
import util.TokenUtils;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cervejas")
public class CervejaResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    //@Authenticated
    //@RolesAllowed("Funcionario")
    public String nome(){
        return "Heineken";
    }

}

