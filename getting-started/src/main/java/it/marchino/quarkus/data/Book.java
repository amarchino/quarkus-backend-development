package it.marchino.quarkus.data;

public class Book {
	private String name;
	private String author;

	public Book() {}

	/**
	 * @param name
	 * @param author
	 */
	public Book(String name, String author) {
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
}
