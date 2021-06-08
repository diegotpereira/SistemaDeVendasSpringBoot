package br.com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.FornecedorDao;
import br.com.java.model.Fornecedor;
import br.com.java.service.FornecedorService;

@Service
@Transactional(readOnly = false)
public class FornecedorServiceImpl implements FornecedorService {
	
	@Autowired
	private FornecedorDao dao;

	@Override
	public void salvar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		dao.save(fornecedor);
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		dao.update(fornecedor);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Fornecedor buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fornecedor> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
