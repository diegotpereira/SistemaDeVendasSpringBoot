package br.com.java.service;

import java.util.List;

import br.com.java.model.Pedido;

public interface PedidoService {
	
	void salvar(Pedido pedido);
	
	void editar(Pedido pedido);
	
	void excluir(Long id);
	
	Pedido buscarPorId(Long id);
	
	List<Pedido> buscarTodos();
}
