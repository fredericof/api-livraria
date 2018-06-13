package com.frederico.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.frederico.api.model.Autor;
import com.frederico.api.model.Isbn;
import com.frederico.api.model.Livro;
import com.frederico.api.model.Nome;

@Component
public class LivroService {
	
	public static List<Livro> livros;
	
	static {
		livros = new ArrayList<Livro>();
		
		Livro livro_1 = new Livro(new Long(1), "Livro 1", "Jose", "978-3-23-129746-1", new Float(200.00));
		Livro livro_2 = new Livro(new Long(2), "Livro 2", "João", "124-3-16-148410-2", new Float(345.00));
		Livro livro_3 = new Livro(new Long(3), "Livro 3", "Maria", "235-3-16-926478-3", new Float(123.123));
		Livro livro_4 = new Livro(new Long(4), "Livro 4", "Carlos", "163-3-13-123246-4", new Float(64.15));
		Livro livro_5 = new Livro(new Long(5), "Livro 5", "Frederico", "157-3-36-143510-5", new Float(33.21));
		Livro livro_6 = new Livro(new Long(6), "Livro 6", "Frederico", "435-4-46-934568-6", new Float(12.35));
		livro_1.getComentario().add("Primeiro Comentario, Segundo Comentario");
		
		livros.add(livro_1);
		livros.add(livro_2);
		livros.add(livro_3);
		livros.add(livro_4);
		livros.add(livro_5);
		livros.add(livro_6);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		LivroService.livros = livros;
	}
	
	public Livro getLivroPorId(Long id) {
		
		for(Livro livro : LivroService.livros) { 
		   if(livro.getId().equals(id)) {
			   return livro;
		   }
		}
		return null; 
	}
	
	public Livro insereComentarioLivro(Long id, List<String> comentario) {
		ListIterator<Livro> iterator = LivroService.livros.listIterator();

		while (iterator.hasNext()) {
			Livro livro = iterator.next();
			if (livro.getId().equals(id)) {
				livro.setComentario(comentario);
				iterator.set(livro);
			}
		}
		return getLivroPorId(id);
	}

	public List<Livro> getLivrosPorAutor(String autor) {
		List<Livro> livros = new ArrayList<Livro>();
		
		for(Livro livro : LivroService.livros) { 
		   if(livro.getAutor().equals(autor)) {
			   livros.add(livro);
		   }
		}
		return livros; 
	}
	
	public Livro getLivroPorIsbn(String isbn) {
		for(Livro livro : LivroService.livros) { 
		   if(livro.getIsbn().equals(isbn)) {
			   return livro;
		   }
		}
		return null; 
	}
	
	public Livro getLivroPorNome(String nome) {
		for(Livro livro : LivroService.livros) { 
		   if(livro.getNome().equals(nome)) {
			   return livro;
		   }
		}
		return null; 
	}

	public List<Autor> buscaAutor() {
		Set<Autor> autores = new HashSet<Autor>();
		
		for(Livro lx : LivroService.livros) {
			Autor autor = new Autor();
			autor.setAutor(lx.getAutor());
			for(Livro ly : LivroService.livros) {
				if(ly.getAutor().equals(autor.getAutor())) {
					autor.getHref().add("/v1/public/livros/" + ly.getId());
				}
			}
			autores.add(autor);
		}
		
		return autores.stream().collect(Collectors.toList());
	}
	
	public List<Isbn> buscaIsbn() {
		List<Isbn> listaIsbn = new ArrayList<Isbn>();
		
		for(Livro lx : LivroService.livros) {
			Isbn isbn = new Isbn();
			isbn.setIsbn(lx.getIsbn());
			isbn.setHref("/v1/public/livros/" + lx.getId());
			listaIsbn.add(isbn);
		}
		
		return listaIsbn;
	}
	
	public List<Nome> buscaNome() {
		List<Nome> listaNome = new ArrayList<Nome>();
		
		for(Livro lx : LivroService.livros) {
			Nome nome = new Nome();
			nome.setNome(lx.getNome());
			nome.setHref("/v1/public/livros/" + lx.getId());
			listaNome.add(nome);
		}
		
		return listaNome;
	}
}
