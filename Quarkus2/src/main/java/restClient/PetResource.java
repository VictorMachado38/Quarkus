package restClient;


import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pets")
public class PetResource {

	@Inject
	@RestClient
	petService petService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findByStatusLocal")
	public List<Pet> methodname(@QueryParam("status") String status) {
		return petService.findByStatus(status);
	}
}