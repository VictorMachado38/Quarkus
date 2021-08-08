package health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class testandoSeEstaSaldavel implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named("Banco de dados Ok").up().build();
        //return null;
    }
}
