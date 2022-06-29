package it.marchino.quarkus.config;

import java.util.Optional;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@StaticInitSafe
@ConfigMapping(prefix = "greeting")
public interface GreetingConfig {

	String name();
	@WithDefault("!")
	String suffix();
	Optional<String> prefix();
	CountryConfig country();

	interface CountryConfig {
		String name();
		Integer id();
	}
}
