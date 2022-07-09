package it.marchino.quarkus.cryptoprice.data;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class MultipartBody {
	@FormParam("file")
	@PartType(MediaType.APPLICATION_OCTET_STREAM)
	private InputStream file;
	@FormParam("name")
	@PartType(MediaType.TEXT_PLAIN)
	private String name;
	/**
	 * @return the file
	 */
	public InputStream getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(InputStream file) {
		this.file = file;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
