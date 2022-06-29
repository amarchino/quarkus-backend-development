package it.marchino.quarkus.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.marchino.quarkus.config.GreetingConfig;

@ApplicationScoped
public class GreetingService {

	@Inject GreetingConfig greetingConfig;

	public String sayHello() {
		return greetingConfig.prefix().orElse("_")
			+ greetingConfig.name()
			+ greetingConfig.suffix()
			+ " Your country is " + greetingConfig.country().name();
	}

	public String sayHello(String name) {
		return String.format("Hello %s, your id is %s", name, UUID.randomUUID());
	}
}
