package panache;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/pessoas")
public class PessoaResource  {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Pessoa> buscarPessoas() {
		return Pessoa.listAll();

		// esse (listAll()) isso aqui é do quarkus-hibernate-orm-panache
		//return "hello";
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public String addPessoa(@RequestBody IncluirPessoaDTO dto) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(dto.getNome());
		pessoa.setTpo(dto.getTipo());
		pessoa.persist();

		Pessoa.stream("nom,","vasdf");
		Pessoa.list("nome", "Victor");
		// isso aqui é do quarkus-hibernate-orm-panache

		return "hello";
	}


}