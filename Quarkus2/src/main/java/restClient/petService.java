package restClient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.junit.jupiter.api.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/pet")
@RegisterRestClient
public interface petService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatus")
    @Timeout(value = 1000)
    public List<Pet> findByStatus(@QueryParam("status") String status);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatus")
    public CompletionStage<List<Pet>> findByStatusAsync(@QueryParam("status") String status);
}

/*
@Path("/pet")
@RegisterRestClient
public interface petService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatus")
    public List<Pet> findByStatus(@QueryParam("status") String status);
}
*/