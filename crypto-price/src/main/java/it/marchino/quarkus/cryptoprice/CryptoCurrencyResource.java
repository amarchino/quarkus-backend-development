package it.marchino.quarkus.cryptoprice;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import it.marchino.quarkus.cryptoprice.data.Currency;
import it.marchino.quarkus.cryptoprice.data.MultipartBody;
import it.marchino.quarkus.cryptoprice.service.CurrencyService;
import it.marchino.quarkus.cryptoprice.service.MultipartService;

@Path("/crypto")
public class CryptoCurrencyResource {

	@Inject
	@RestClient
	CurrencyService currencyService;

	@Inject
	@RestClient
	MultipartService multipartService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CompletionStage<Collection<Currency>> getCrypto(@QueryParam("id") String id) {
		return currencyService.getCurrency(id);
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String echoFile(@MultipartForm MultipartBody body) {
		return body.getName();
	}

	@GET
	@Path("/echo")
	@Produces(MediaType.TEXT_PLAIN)
	public String callEcho() {
		MultipartBody body = new MultipartBody();
		body.setFile(new ByteArrayInputStream("Hello World".getBytes()));
		body.setName("hello.txt");
		return multipartService.sendFile(body);
	}
}
