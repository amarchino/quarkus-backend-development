package it.marchino.quarkus;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(
		title = "Getting started API",
		description = "Our test API description",
		version = "1.2"
	),
	servers = {
		@Server(
			url = "/quarkus.study.local",
			description = "Dev server"
		)
	}
)
public class QuarkusApplication extends Application {
}
