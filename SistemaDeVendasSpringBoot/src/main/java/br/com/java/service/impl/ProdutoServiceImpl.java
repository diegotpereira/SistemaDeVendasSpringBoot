package br.com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.java.dao.ProdutoDao;
import br.com.java.model.Produto;
import br.com.java.service.ProdutoService;

@Service
@Transactional(readOnly = false)
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoDao dao;

	@Override
	public void salvar(Produto produto) {
		// TODO Auto-generated method stub
		dao.save(produto);
	}

	@Override
	public void editar(Produto produto) {
		// TODO Auto-generated method stub
		dao.update(produto);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Produto buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly =  true)
	public List<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
