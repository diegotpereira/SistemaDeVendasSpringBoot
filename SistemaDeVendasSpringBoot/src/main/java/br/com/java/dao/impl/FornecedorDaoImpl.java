package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.DaoGenerico;
import br.com.java.dao.FornecedorDao;
import br.com.java.model.Fornecedor;

@Repository
public class FornecedorDaoImpl extends DaoGenerico<Fornecedor, Long> implements FornecedorDao{

}
