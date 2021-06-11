package br.com.java.dao;

import java.util.List;

import br.com.java.model.ProdutoPedido;

public interface ProdutoPedidoDao {
	
	void save(ProdutoPedido produtoPedido);
	
	void update(ProdutoPedido produtoPedido);
	
	void delete(Long id);
	
	ProdutoPedido findById(Long id);
	
	List<ProdutoPedido> findAll();
}
