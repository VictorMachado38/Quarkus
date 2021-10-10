package hibernate;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Traced
public class ProdutoService {

    @Inject EntityManager entityManager;

  //  @Inject @RestClient unidadeFederativaService ufService;

    public List<Produto> getProdutos()
    { return  entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public void addProduto(Produto p)
    { entityManager.persist(p);
    }
}
