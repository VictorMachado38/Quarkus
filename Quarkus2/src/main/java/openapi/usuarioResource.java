package openapi;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
@Tag(name = "usuario")
public class usuarioResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Operation(
	summary = "Busca TUDO",
	description = "Buscar tudos os usaurio, e vai vir tudo"
)
	public List<Usuario> bucarUsuarios() {
		return Usuario.listAll();
	}


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adicinarUsuario(@RequestBody Usuario  usuario)   {
        return "hello";
    }

	@GET
	@Path("{idUsuario}/produtos")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Busca prodtos de um usurio",
			description = "Buscar tudos os usaurio, e vai vir tudo"
	)
	@Tag(name = "usuarios")
	@Tag(name = "produtos")
	@APIResponse(
	responseCode = "404",
	description = "caso o usuario ano exista"

)
	@APIResponse(
			responseCode = "200",
			description = "Ok !!"

	)
	public List<Usuario> bucarUsuarios(@QueryParam("idUsuario") Integer idUsuario) {
		return Usuario.listAll();
	}

}