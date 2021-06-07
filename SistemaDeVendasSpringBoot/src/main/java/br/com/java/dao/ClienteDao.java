package br.com.java.dao;

import java.util.List;

import br.com.java.model.Cliente;

public interface ClienteDao {
	
	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Long id);
	
	Cliente findById(Long id);
	
	List<Cliente>findAll();
}
