package br.com.java.service;

import java.util.List;

import br.com.java.model.Fornecedor;

public interface FornecedorService {
	
	void salvar(Fornecedor fornecedor);
	
	void editar(Fornecedor fornecedor);
	
	void excluir(Long id);
	
	Fornecedor buscarPorId(Long id);
	
	List<Fornecedor> buscarTodos();
}
