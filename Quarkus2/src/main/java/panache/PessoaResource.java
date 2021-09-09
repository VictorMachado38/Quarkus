package panache;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/pessoas")
@Tag(name = "pessoas")
public class PessoaResource  {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Pessoa> buscarPessoas() {
		return Pessoa.listAll();

		// esse (listAll()) isso aqui é do quarkus-hibernate-orm-panache
		//return "hello";
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void addPessoa(@RequestBody IncluirPessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(dto.getNome());
		pessoa.setTipo(dto.getTipo());
		pessoa.persist();

	}

	/*
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void addPessoa(@RequestBody IncluirPessoaDTO dto) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(dto.getNome());
		pessoa.setTipo(dto.getTipo());
		pessoa.persist();

		//Pessoa.stream("nom,","vasdf");
		// Pessoa.list("nome", "Victor");
		// isso aqui é do quarkus-hibernate-orm-panache

		//return "hello";
	}*/


}