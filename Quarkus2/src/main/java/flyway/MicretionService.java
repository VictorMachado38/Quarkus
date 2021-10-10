package flyway;

import io.quarkus.runtime.StartupEvent;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static org.jboss.resteasy.resteasy_jaxrs.i18n.LogMessages.LOGGER;

@ApplicationScoped
public class MicretionService {
    
    @Inject
    Flyway flyway;
    
    void quandoIniciar(@Observes StartupEvent ev){
        LOGGER.info("Inializando DB com Flyway");
        flyway.clean();
        flyway.migrate();

        MigrationInfo current = flyway.info().current();
        if (current != null)
        {
            LOGGER.info(current.getVersion().getVersion());
            LOGGER.info(current.getState().toString());
        }
        else{
            LOGGER.info("Sem versao de FLYWAY");
        }

    }
}
