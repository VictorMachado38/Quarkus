package elasticsearch;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import io.quarkus.runtime.StartupEvent;

import java.util.List;
import java.util.Optional;

@Path("/autores")
public class AutorResource {

    @Inject
    EntityManager entityManager;
    @Inject ElasticsearchService elasticsearchService;
    @Transactional
    void onStart(@Observes StartupEvent ev) throws InterruptedException {
        // elasticsearchService.rebuildIndexes();
    }

     @GET
     @Transactional
     @Produces(MediaType.APPLICATION_JSON)
     public List<Autor> buscarAutor(){
        return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
        //return null;
        //return elasticsearchService.search(Autor.class, termo, tamanho, "nome", "livros.titulo", "livros.conteudo");
     }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Autor.findById(id).delete();
    }
}