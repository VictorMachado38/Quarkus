package validations;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/validations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ValidationsResource {

    @Inject
    Validator validator;

    @Inject
    ValidationService sevice;

    @GET
    @Path("/query")
    public void query(@QueryParam("i") @Max(10) Integer i){

    }

    @POST
    @Path("/annotation")
    public void annotation(@RequestBody @Valid DTOExemplo exemploDTO){

    }

    @POST
    @Path("/manualValidation")
    public void manual(@RequestBody DTOExemplo exemploDTO){

         Set<ConstraintViolation<DTOExemplo>> violations = validator.validate(exemploDTO);
         if (violations.isEmpty()){
             System.out.println("Esta vazia");
         }
         else{
             System.out.println(violations);

         }

    }

    @POST
    @Path("/service")
    public void sevice(@RequestBody DTOExemplo exemploDTO){
            sevice.fazAlgo(exemploDTO);
    }


}
