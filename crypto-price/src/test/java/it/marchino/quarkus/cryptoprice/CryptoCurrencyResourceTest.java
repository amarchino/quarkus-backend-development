package it.marchino.quarkus.cryptoprice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.stream.Stream;

@QuarkusTest
public class CryptoCurrencyResourceTest {

	private static Stream<Arguments> dataset() {
		return Stream.of(
			Arguments.of("80", "Ethereum", "ETH"),
			Arguments.of("90", "Bitcoin", "BTC")
		);
	}

	@ParameterizedTest(name = "Read crypto id={0}, name={1}, symbol={2}")
	@MethodSource("dataset")
	public void testCrypto(String id, String name, String symbol) {
		given()
			.when().get("/crypto?id=" + id)
			.then()
			.statusCode(200)
			.body(
				"$.size()", is(1),
				"[0].id", is(id),
				"[0].name", is(name),
				"[0].symbol", is(symbol));
	}

}
