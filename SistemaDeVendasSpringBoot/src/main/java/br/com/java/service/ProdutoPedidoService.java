package br.com.java.service;

import java.util.List;

import br.com.java.model.ProdutoPedido;

public interface ProdutoPedidoService {
	
	void salvar(ProdutoPedido produtoPedido);
	
	void editar(ProdutoPedido produtoPedido);
	
	void excluir(Long id);
	
	ProdutoPedido buscarPorId(Long id);
	
	List<ProdutoPedido> buscarTodos();
}
