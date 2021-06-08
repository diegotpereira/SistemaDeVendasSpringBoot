package br.com.java.service;

import java.util.List;

import br.com.java.model.Produto;

public interface ProdutoService {
	
	void salvar(Produto produto);
	
	void editar(Produto produto);
	
	void excluir(Long id);
	
	Produto buscarPorId(Long id);
	
	List<Produto> buscarTodos();
}
