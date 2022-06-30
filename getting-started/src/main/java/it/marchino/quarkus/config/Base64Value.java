package it.marchino.quarkus.config;

import java.util.Base64;

import org.eclipse.microprofile.config.spi.Converter;

public class Base64Value {
	private String value;

	public Base64Value(String base64) {
		this.value = new String(Base64.getDecoder().decode(base64));
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static class Base64ValueConverter implements Converter<Base64Value> {

		@Override
		public Base64Value convert(String value) throws IllegalArgumentException, NullPointerException {
			return new Base64Value(value);
		}

	}
}
