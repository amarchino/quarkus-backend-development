package it.marchino.quarkus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.marchino.quarkus.data.Book;
import it.marchino.quarkus.service.BookService;

@Path("/book")
public class BookResource {
	@Inject Validator validator;
	@Inject BookService bookService;

	private static List<Book> books = new ArrayList<>();

	static {
		books.add(new Book("The Freelancer's Bible", "IDK", 10));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
		// return Response.ok(books).build();
		// return Response.serverError().build();
		return Response.status(202).entity(books).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(/*@Valid*/ Book book) {
		bookService.checkBook(book);
		// Set<ConstraintViolation<Book>> violations = validator.validate(book);
		// if(!violations.isEmpty()) {
		// 	return Response.status(400).build();
		// }
		if(books.size() > 5) {
			return Response.status(400).entity("No more than 5 books allowed").build();
		}
		books.add(book);
		return Response.ok(book).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Book updateBook(@PathParam("id") Integer index, Book book) {
		books.set(index, book);
		return book;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Book deleteBook(@PathParam("id") Integer index) {
		return books.remove(index.intValue());
	}
}
