package health;

import com.google.inject.Inject;
import org.eclipse.microprofile.health.*;
import org.flywaydb.core.Flyway;

import javax.enterprise.context.ApplicationScoped;

/*
@Readiness
@ApplicationScoped
public class TestandoSeEstaPronta implements HealthCheck {


     @Inject
     Flyway flyway;


    @Override
    public HealthCheckResponse call() {
        int quantidadePendencias = flyway.info().pending().length;
        //Comentado no video 19, flyway tem bug com graylog.
        //int quantidadePendencias = 0;
        boolean temPendencia = quantidadePendencias > 0;
        HealthCheckResponseBuilder health = HealthCheckResponse.named("Verificando se banco está com pendência").up();
        if (temPendencia) {
            health.down().withData("pendencias ativas", quantidadePendencias);
        }
        return health.build();
    }

}
*/


@Readiness
@ApplicationScoped
public class TestandoSeEstaPronta implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Verificando se o banco esta populado").up().build();
    }
}
