package br.com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.FuncionarioDao;
import br.com.java.model.Funcionario;
import br.com.java.service.FuncionarioService;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioDao dao;

	@Override
	public void salvar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		dao.update(funcionario);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
