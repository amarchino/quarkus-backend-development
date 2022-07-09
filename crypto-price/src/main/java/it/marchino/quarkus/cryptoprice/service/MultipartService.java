package it.marchino.quarkus.cryptoprice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import it.marchino.quarkus.cryptoprice.data.MultipartBody;

@RegisterRestClient(configKey = "config.api.multipart")
@Path("/crypto")
public interface MultipartService {
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	String sendFile(@MultipartForm MultipartBody body);

}
