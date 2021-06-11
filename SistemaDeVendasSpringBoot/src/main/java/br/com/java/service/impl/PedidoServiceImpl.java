package br.com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.PedidoDao;
import br.com.java.model.Pedido;
import br.com.java.service.PedidoService;

@Service
@Transactional(readOnly = false)
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoDao dao;

	@Override
	public void salvar(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.save(pedido);
	}

	@Override
	public void editar(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.update(pedido);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
