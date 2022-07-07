package it.marchino.quarkus.service;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

import it.marchino.quarkus.data.Book;

@ApplicationScoped
public class BookService {

	public Book checkBook(@Valid Book book) {
		return book;
	}
}
