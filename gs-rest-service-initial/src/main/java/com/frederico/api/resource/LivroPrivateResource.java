package com.frederico.api.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Livro;

@RestController
@RequestMapping("/v1/private/livros")
public class LivroPrivateResource {
	
	@PostMapping()
	public ResponseEntity<?> cadastrarLivros(@RequestBody List<Livro> livrosJson) {
		
		return livrosJson != null ? ResponseEntity.status(HttpStatus.OK).body(livrosJson) 
				: ResponseEntity.status(HttpStatus.CREATED)
					.contentType(MediaType.TEXT_PLAIN).body("Livro não encontrado.");
		
	}

}
