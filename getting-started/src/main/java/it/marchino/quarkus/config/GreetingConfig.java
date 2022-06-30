package it.marchino.quarkus.config;

import java.util.Optional;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithConverter;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@StaticInitSafe
@ConfigMapping(prefix = "greeting")
public interface GreetingConfig {

	String name();
	@WithDefault("!")
	String suffix();
	Optional<String> prefix();
	CountryConfig country();
	@WithConverter(Base64Value.Base64ValueConverter.class)
	@WithName("base64name")
	Base64Value base64Value();

	interface CountryConfig {
		String name();
		Integer id();
	}
}
