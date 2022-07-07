package it.marchino.quarkus.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Book {
	@NotBlank(message = "Name shouldn't be blank")
	private String name;
	@NotBlank(message = "Author shouldn't be blank")
	private String author;
	@Min(value = 1, message = "Numbe of pages should be at least one")
	private Integer pages;

	public Book() {}

	/**
	 * @param name
	 * @param author
	 */
	public Book(String name, String author, Integer pages) {
		this.name = name;
		this.author = author;
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
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the pages
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}

}
