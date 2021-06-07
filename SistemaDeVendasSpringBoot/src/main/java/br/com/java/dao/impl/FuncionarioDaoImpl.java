package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.DaoGenerico;
import br.com.java.dao.FuncionarioDao;
import br.com.java.model.Funcionario;

@Repository
public class FuncionarioDaoImpl extends DaoGenerico<Funcionario, Long> implements FuncionarioDao{

}
