package keycloak;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/computadores")
public class ComputadoresResource {

	@GET
	@Path("/publico")
	@Produces(MediaType.TEXT_PLAIN)
	public String methodname() {
		return "hello publico";
	}


	@GET
	@Path("/publico")
	@Produces(MediaType.TEXT_PLAIN)
	public String protegido() {
		return "hello protegido";
	}
}



