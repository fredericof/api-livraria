package com.frederico.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frederico.api.model.Carrinho;
import com.frederico.api.model.ItemCarrinho;
import com.frederico.api.model.Livro;

@Component
public class CarrinhoService {

	public static Carrinho carrinho_1;
	public static Carrinho carrinho_2;
	
	@Autowired
	private LivroService livroService;
	
	static {
		CarrinhoService.carrinho_1 = new Carrinho();
		CarrinhoService.carrinho_2 = new Carrinho();
		
		Livro livro_1 = new Livro(new Long(1), "Livro 1", "Jose", "978-3-23-129746-1", new Float(200.00));
		Livro livro_2 = new Livro(new Long(2), "Livro 2", "João", "124-3-16-148410-2", new Float(345.00));
		Livro livro_3 = new Livro(new Long(3), "Livro 3", "Maria", "235-3-16-926478-3", new Float(123.123));
		Livro livro_4 = new Livro(new Long(4), "Livro 4", "Carlos", "163-3-13-123246-4", new Float(64.15));
		Livro livro_5 = new Livro(new Long(5), "Livro 5", "Frederico", "157-3-36-143510-5", new Float(33.21));
		Livro livro_6 = new Livro(new Long(6), "Livro 6", "Frederico", "435-4-46-934568-6", new Float(12.35));
		
		CarrinhoService.carrinho_1.getItens().add(new ItemCarrinho(livro_1, new Integer(2)));
		CarrinhoService.carrinho_1.getItens().add(new ItemCarrinho(livro_3, new Integer(1)));
		CarrinhoService.carrinho_1.getItens().add(new ItemCarrinho(livro_5, new Integer(4)));
		
		CarrinhoService.carrinho_2.getItens().add(new ItemCarrinho(livro_2, new Integer(1)));
		CarrinhoService.carrinho_2.getItens().add(new ItemCarrinho(livro_4, new Integer(2)));
		CarrinhoService.carrinho_2.getItens().add(new ItemCarrinho(livro_6, new Integer(1)));
	}
	
	
	public Carrinho getCarrinho(String session_id) {
		if ("1".equals(session_id)) {
			return CarrinhoService.carrinho_1;
		} else if ("2".equals(session_id)) {
			return CarrinhoService.carrinho_2;
		}
		
		return null;
	}

	public Carrinho insereItemCarrinho(String session_id, ItemCarrinho itemCarrinho) {
		if ("1".equals(session_id)) {
			float valorTotal = 0;
			
			CarrinhoService.carrinho_1.getItens().add(
					new ItemCarrinho(livroService.getLivroPorId(itemCarrinho.getLivro().getId()), itemCarrinho.getQuantidade()));
			
			for (ItemCarrinho item : carrinho_1.getItens()) {
				valorTotal += item.getLivro().getPreco()*item.getQuantidade();
			}
			
			CarrinhoService.carrinho_1.setValorTotal(valorTotal);
			
			return CarrinhoService.carrinho_1;
		} else if ("2".equals(session_id)) {
			float valorTotal = 0;
			
			CarrinhoService.carrinho_2.getItens().add(
					new ItemCarrinho(livroService.getLivroPorId(itemCarrinho.getLivro().getId()), itemCarrinho.getQuantidade()));
			
			for (ItemCarrinho item : carrinho_1.getItens()) {
				valorTotal += item.getLivro().getPreco()*item.getQuantidade();
			}
			
			CarrinhoService.carrinho_1.setValorTotal(valorTotal);
			
			return CarrinhoService.carrinho_2;
		}
		
		return null;
	}
	
	public Carrinho deletaItemCarrinho(String session_id, ItemCarrinho itemCarrinho) {
		if ("1".equals(session_id)) {
			float valorTotal = 0;
			
			CarrinhoService.carrinho_1.getItens().remove(itemCarrinho);
			
			for (ItemCarrinho item : carrinho_1.getItens()) {
				valorTotal += item.getLivro().getPreco()*item.getQuantidade();
			}
			
			CarrinhoService.carrinho_1.setValorTotal(valorTotal);
			
			return CarrinhoService.carrinho_1;
		} else if ("2".equals(session_id)) {
			float valorTotal = 0;
			
			CarrinhoService.carrinho_2.getItens().remove(itemCarrinho);
			
			for (ItemCarrinho item : carrinho_2.getItens()) {
				valorTotal += item.getLivro().getPreco()*item.getQuantidade();
			}
			
			CarrinhoService.carrinho_2.setValorTotal(valorTotal);
			
			return CarrinhoService.carrinho_2;
		}
		
		return null;
	}
}
