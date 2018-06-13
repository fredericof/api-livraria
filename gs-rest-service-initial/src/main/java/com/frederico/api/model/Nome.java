package com.frederico.api.model;

public class Nome {
	
	private String nome;
	private String href;
	
	public Nome() {};
	
	public Nome(String nome, String href) {
		this.nome = nome;
		this.href = href;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}
