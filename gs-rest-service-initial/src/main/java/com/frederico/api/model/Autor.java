package com.frederico.api.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	
	private String autor;
	private List<String> href = new ArrayList<String>();
	
	public Autor() {};
	
	public Autor(String autor) {
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<String> getHref() {
		return href;
	}
	public void setHref(List<String> href) {
		this.href = href;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		return true;
	}
	
}
