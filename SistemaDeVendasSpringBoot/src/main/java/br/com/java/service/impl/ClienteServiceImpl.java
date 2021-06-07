package br.com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.ClienteDao;
import br.com.java.model.Cliente;
import br.com.java.service.ClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao dao;

	@Override
	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.update(cliente);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
