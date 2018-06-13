package com.frederico.api.model;

public class Isbn {
	
	private String isbn;
	private String href;
	
	public Isbn() {};
	
	public Isbn(String isbn, String href) {
		this.isbn = isbn;
		this.href = href;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}
