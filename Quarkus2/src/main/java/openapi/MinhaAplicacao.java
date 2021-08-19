package openapi;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(description = "Conjunto de endpoints para enisnar o quarkus.",title = "Estundo Quarkus", version = "7878.2.1",contact = @Contact(name = "VITAO", email = "victor.pedrozo@hotmail.com")))
public class MinhaAplicacao extends Application {
}
