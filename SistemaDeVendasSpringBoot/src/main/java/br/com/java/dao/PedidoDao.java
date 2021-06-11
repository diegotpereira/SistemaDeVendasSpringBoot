package br.com.java.dao;

import java.util.List;

import br.com.java.model.Pedido;

public interface PedidoDao {
	
	void save(Pedido pedido);
	
	void update(Pedido pedido);
	
	void delete(Long id);
	
	Pedido findById(Long id);
	
	List<Pedido> findAll();
}
