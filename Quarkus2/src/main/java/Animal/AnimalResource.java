package Animal;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/animal")
@Tag(name = "Animal")
public class AnimalResource {

	@Inject AnimalDAO animalDAO;

	@GET
	@Operation(
	summary = "Animal//Teste",
	description = "Retorna somente o hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String methodname() {
		return "Hello animal";
	}

	@Path("/busca")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@APIResponse(
	responseCode = "200",
	description = "OBOAAAAAAAA deu BOM!")
	public List<Animal> bucarAnimal(){

		return animalDAO.getAnimal();
	}


	@Path("/add")
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Transactional
	@Operation(
	summary = "Para adicionar um animal",
	description = "Add qualer animal que voce querira, não importa a raça nem especie"
)

	public  void addAniamal (@RequestBody Animal animal)
	{
		//return "Foi";
		animalDAO.addAnimal(animal);
	}


}