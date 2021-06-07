package br.com.java.service;

import java.util.List;

import br.com.java.model.Cliente;

public interface ClienteService {
	
	void salvar(Cliente cliente);
	
	void editar(Cliente cliente);
	
	void excluir(Long id);
	
	Cliente buscarPorId(long id);
	
	List<Cliente> buscarTodos();
}
