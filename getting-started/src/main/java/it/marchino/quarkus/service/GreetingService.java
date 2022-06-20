package it.marchino.quarkus.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

	public String sayHello(String name) {
		return String.format("Hello %s, your id is %s", name, UUID.randomUUID());
	}
}
