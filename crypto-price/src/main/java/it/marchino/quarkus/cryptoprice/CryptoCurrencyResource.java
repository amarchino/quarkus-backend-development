package it.marchino.quarkus.cryptoprice;

import java.util.Collection;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import it.marchino.quarkus.cryptoprice.data.Currency;
import it.marchino.quarkus.cryptoprice.service.CurrencyService;

@Path("/crypto")
public class CryptoCurrencyResource {

	@Inject
	@RestClient
	CurrencyService currencyService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CompletionStage<Collection<Currency>> getCrypto(@QueryParam("id") String id) {
		return currencyService.getCurrency(id);
	}
}
