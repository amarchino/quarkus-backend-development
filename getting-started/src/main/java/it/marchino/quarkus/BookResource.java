package it.marchino.quarkus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class BookResource {

	private static List<String> books = new ArrayList<>();

	static {
		books.add("The Freelancer's Bible");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBooks() {
		return books.stream().collect(Collectors.joining(","));
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addBook(String book) {
		books.add(book);
		return book;
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String updateBook(@PathParam("id") Integer index, String book) {
		books.set(index, book);
		return book;
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String deleteBook(@PathParam("id") Integer index) {
		return books.remove(index.intValue());
	}
}
