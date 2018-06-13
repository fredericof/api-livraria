package com.frederico.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Carrinho;
import com.frederico.api.model.ItemCarrinho;
import com.frederico.api.service.CarrinhoService;

@RestController
@RequestMapping("/v1/public/livros")
public class CarrinhoResource {

	@Autowired
	private CarrinhoService carrinhoService;
	
	@GetMapping("/carrinho/{session_id}")
	public ResponseEntity<?> buscarLivros(@PathVariable String session_id) {
		
		Carrinho carrinho = carrinhoService.getCarrinho(session_id);
		
		return carrinho != null ? ResponseEntity.status(HttpStatus.OK).body(carrinho) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Carrinho não encontrado.");
	}
	
	@PostMapping("/carrinho/{session_id}")
	public ResponseEntity<?> insereItemCarrinho(@PathVariable String session_id, @RequestBody ItemCarrinho itemCarrinho) {
		
		Carrinho carrinho = carrinhoService.insereItemCarrinho(session_id, itemCarrinho);
		
		return carrinho != null ? ResponseEntity.status(HttpStatus.CREATED).body(carrinho) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Carrinho não encontrado.");
	}
	
	@DeleteMapping("/carrinho/{session_id}")
	public ResponseEntity<?> deletaItemCarrinho(@PathVariable String session_id, @RequestBody ItemCarrinho itemCarrinho) {
		
		Carrinho carrinho = carrinhoService.deletaItemCarrinho(session_id, itemCarrinho);
		
		return carrinho != null ? ResponseEntity.status(HttpStatus.OK).body(carrinho) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Carrinho não encontrado.");
	}
	
}
