package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.DaoGenerico;
import br.com.java.dao.ProdutoDao;
import br.com.java.model.Produto;

@Repository
public class ProdutoDaoImpl extends DaoGenerico<Produto, Long> implements ProdutoDao {

}
