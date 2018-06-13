package com.frederico.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Autor;
import com.frederico.api.model.Isbn;
import com.frederico.api.model.Livro;
import com.frederico.api.model.Nome;
import com.frederico.api.service.LivroService;

@RestController
@RequestMapping("/v1/public/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping()
	public List<Livro> buscarLivros() {
		return livroService.getLivros();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Livro livro = livroService.getLivroPorId(id);
		
		return livro != null ? ResponseEntity.status(HttpStatus.OK).body(livro) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Livro não encontrado.");
	}
	
	@PostMapping("/{id}/comentario")
	public ResponseEntity<?> insereComentario(@PathVariable Long id, @RequestBody Livro livroJson) {
		Livro livro = livroService.insereComentarioLivro(id, livroJson.getComentario());
		
		return livro != null ? ResponseEntity.status(HttpStatus.CREATED).body(livro) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Livro não encontrado.");
	}
	
	@GetMapping("/autor/{autor}")
	public ResponseEntity<?> buscaPorAutor(@PathVariable String autor) {
		List<Livro> livros = livroService.getLivrosPorAutor(autor);
		
		return !livros.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(livros) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Livro não encontrado.");
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<?> buscaPorIsbn(@PathVariable String isbn) {
		Livro livro = livroService.getLivroPorIsbn(isbn);
		
		return livro != null ? ResponseEntity.status(HttpStatus.OK).body(livro) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Livro não encontrado.");
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> buscaPorNome(@PathVariable String nome) {
		Livro livro = livroService.getLivroPorNome( nome);
		
		return livro != null ? ResponseEntity.status(HttpStatus.OK).body(livro) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Livro não encontrado.");
	}
	
	@GetMapping("/autor")
	public List<Autor> buscaAutor() {
		return livroService.buscaAutor();
	}
	
	@GetMapping("/isbn")
	public List<Isbn> buscaIsbn() {
		return livroService.buscaIsbn();
	}
	
	@GetMapping("/nome")
	public List<Nome> buscaNome() {
		return livroService.buscaNome();
	}
	
}
