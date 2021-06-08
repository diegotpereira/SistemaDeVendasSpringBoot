package br.com.java.dao;

import java.util.List;

import br.com.java.model.Produto;

public interface ProdutoDao {
	
	void save(Produto produto);
	
	void update(Produto produto);
	
	void delete(Long id);
	
	Produto findById(Long id);
	
	List<Produto> findAll();
}
