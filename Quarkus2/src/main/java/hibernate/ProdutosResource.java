package hibernate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/produtos")
public class ProdutosResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON
    )
    public List<Produto> getProdutos()
    {
        return  entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @POST
    @Transactional
    @Consumes(value = MediaType.APPLICATION_JSON    )
    public void addProduto(Produto p)
    {
        entityManager.persist(p);
    }
}
