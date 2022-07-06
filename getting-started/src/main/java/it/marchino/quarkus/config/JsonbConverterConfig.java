package it.marchino.quarkus.config;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.JsonbConfig;

import io.quarkus.jsonb.JsonbConfigCustomizer;

@ApplicationScoped
public class JsonbConverterConfig implements JsonbConfigCustomizer {

	@Override
	public void customize(JsonbConfig jsonbConfig) {
		// jsonbConfig.withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES);
	}

}
