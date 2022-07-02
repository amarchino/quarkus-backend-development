package it.marchino.quarkus.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import it.marchino.quarkus.config.GreetingConfig;

@ApplicationScoped
public class GreetingService {

	private static Logger LOGGER = Logger.getLogger(GreetingService.class);

	@Inject GreetingConfig greetingConfig;

	public String sayHello() {
		LOGGER.debug("Saying hello to random user");
		return greetingConfig.prefix().orElse("_")
			+ greetingConfig.name()
			+ greetingConfig.suffix()
			+ " Your country is " + greetingConfig.country().name()
			+ " - " + greetingConfig.base64Value();
	}

	public String sayHello(String name) {
		return String.format("Hello %s, your id is %s", name, UUID.randomUUID());
	}
}
