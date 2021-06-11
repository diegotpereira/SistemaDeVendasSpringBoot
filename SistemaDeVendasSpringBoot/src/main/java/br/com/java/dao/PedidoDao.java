package br.com.java.dao;

import java.util.List;

import br.com.java.model.Venda;

public interface VendaDao {
	
	void save(Venda venda);
	
	void update(Venda venda);
	
	void delete(Long id);
	
	Venda findById(Long id);
	
	List<Venda> findAll();
}
