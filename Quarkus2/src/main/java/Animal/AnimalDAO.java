package Animal;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
@Traced
public class AnimalDAO {

    @Inject EntityManager entityManager;

    public List<Animal> getAnimal(){

        return entityManager.createQuery("select a from Animal a", Animal.class).getResultList();
    }


    public void addAnimal (Animal a)
    {
        entityManager.persist(a);
    }


}
