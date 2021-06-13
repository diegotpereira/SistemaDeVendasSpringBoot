package br.com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.VendaDao;
import br.com.java.model.Venda;
import br.com.java.service.VendaService;

@Service
@Transactional(readOnly = false)
public class VendaServiceImpl implements VendaService{
	
	@Autowired
	private VendaDao dao;

	@Override
	public void salvar(Venda venda) {
		// TODO Auto-generated method stub
		dao.save(venda);
	}

	@Override
	public void editar(Venda venda) {
		// TODO Auto-generated method stub
		dao.update(venda);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Venda buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Venda> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
