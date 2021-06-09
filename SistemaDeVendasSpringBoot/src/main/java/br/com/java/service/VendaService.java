package br.com.java.service;

import java.util.List;

import br.com.java.model.Venda;

public interface VendaService {
	
	void salvar(Venda venda);
	
	void editar(Venda venda);
	
	void excluir(Long id);
	
	Venda buscarPorId(Long id);
	
	List<Venda> buscarTodos();
}
