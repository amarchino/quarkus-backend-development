package it.marchino.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import org.hamcrest.CoreMatchers;

@QuarkusTest
public class GreetingResourceTest {

	@Test
	public void testHelloEndpoint() {
		RestAssured.given()
			.when().get("/hello")
			.then()
			.statusCode(200)
			.body(CoreMatchers.is("_hello test! Your country is Germany - Hello"));
	}

	@Test
	public void testHelloWithNameEndpoint() {
		final String name = UUID.randomUUID().toString();
		RestAssured.given()
			.when().get("/hello/" + name)
			.then()
			.statusCode(200)
			.body(CoreMatchers.is("Hello " + name + ", your id is 1234"));
	}

}
