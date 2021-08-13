package monitoramento;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/carros")
public class CarrosResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Counted(	name = "Contador de numero de carros")
	public String methodname() {
		return "Olá";
	}
}