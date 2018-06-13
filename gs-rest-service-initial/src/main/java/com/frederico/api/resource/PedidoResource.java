package com.frederico.api.resource;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Carrinho;
import com.frederico.api.model.Pedido;
import com.frederico.api.service.CarrinhoService;

@RestController
@RequestMapping("/v1/public/pedido")
public class PedidoResource {
	
	@PostMapping("/{session_id}")
	public ResponseEntity<?> realizaPedido(@PathVariable String session_id, @RequestBody Carrinho carrinho) {
		
		Pedido pedido = new Pedido((long)(Math.random()*100), session_id, new Date(),
				"Pedido em processamento", carrinho, (float)300.22);
		
		return pedido != null ? ResponseEntity.status(HttpStatus.OK).body(pedido) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Pedido não pode ser efetuado.");
	}
	
	@GetMapping("/{pedido_id}/status")
	public ResponseEntity<?> statusPedido(@PathVariable String pedido_id) {
		
		Pedido pedido = new Pedido(Long.parseLong(pedido_id), String.valueOf((Math.random()*100)), new Date(),
				"Pedido em processamento", CarrinhoService.carrinho_1, (float)300.22);
		
		return pedido != null ? ResponseEntity.status(HttpStatus.OK).body(pedido) 
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Pedido não encontrado.");
	}

}
