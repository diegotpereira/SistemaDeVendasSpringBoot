package br.com.java.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.ProdutoPedidoDao;
import br.com.java.model.ProdutoPedido;
import br.com.java.service.ProdutoPedidoService;

@Service
@Transactional(readOnly = false)
public class ProdutoPedidoServiceImpl implements ProdutoPedidoService {
	
	@Autowired
	private ProdutoPedidoDao dao;

	@Override
	public void salvar(ProdutoPedido produtoPedido) {
		// TODO Auto-generated method stub
		dao.save(produtoPedido);
	}

	@Override
	public void editar(ProdutoPedido produtoPedido) {
		// TODO Auto-generated method stub
		dao.update(produtoPedido);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProdutoPedido buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProdutoPedido> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
