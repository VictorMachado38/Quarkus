package fault;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.hibernate.annotations.common.util.impl.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Console;
import java.util.Random;

@Path("/fault")
public class FaultResource {

	@GET
    @Path("timeout")
	@Timeout(100)
	@Produces(MediaType.TEXT_PLAIN)
	@Fallback(
	fallbackMethod = "methodnameFallBack"//,
	//applyOn = ,
	//skipOn =
)
	public String methodname() throws InterruptedException {
	    Thread.sleep(new Random().nextInt(500));
		return "hello timeout";
	}

	public String methodnameFallBack() throws InterruptedException {

		return "hello Fall Back";
	}


	@GET
	@Path("retry")
	//@Timeout(100)
	@Retry(
	//retryOn = ,
	maxRetries = 1 //,
	//maxDuration = ,
	//abortOn =
)
	@Produces(MediaType.TEXT_PLAIN)
	public String retry() throws InterruptedException {

		if (new Random().nextBoolean())
			//Thread.sleep(new Random().nextInt(500));
			throw new NullPointerException();
		return "hello retry";
	}

	@GET
	@Path("/circuit")
	//@Timeout
	@CircuitBreaker(
	requestVolumeThreshold=5,
	failureRatio=0.5,
	delay =10000,
	successThreshold=10
	//failOn = ,
	//skipOn =
)
	@Produces(MediaType.TEXT_PLAIN)
	public String circuitBreaker() throws InterruptedException {
		if ( new Random().nextInt(3) >= 2) {
			//Thread.sleep(new Random().nextInt(500));
			throw new NullPointerException();}

		return "hello Circuit Braker";
	}


}