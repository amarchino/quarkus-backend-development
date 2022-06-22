package it.marchino.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.marchino.quarkus.service.GreetingService;

@Path("/hello")
public class GreetingResource {
	@Inject GreetingService greetingService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return greetingService.sayHello();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}")
	public String hello(@PathParam("name") String name) {
		return greetingService.sayHello(name);
	}

}
