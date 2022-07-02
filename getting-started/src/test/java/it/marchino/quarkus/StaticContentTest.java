package it.marchino.quarkus;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class StaticContentTest {
	@TestHTTPResource("index.html") URL url;

	@Test
	public void testRootPath() throws IOException {
		String body = IOUtils.toString(url, Charset.defaultCharset());
		Assertions.assertTrue(body.contains("<li>ArtifactId: <code>getting-started</code>!!</li>"));
	}
}
