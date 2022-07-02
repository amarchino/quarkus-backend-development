package it.marchino.quarkus.service;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingServiceTest {

	@Inject GreetingService greetingService;

	@Test
	void checkReturnsHello() {
		Assertions.assertEquals("_hello test! Your country is Germany - Hello", greetingService.sayHello());
	}
}
