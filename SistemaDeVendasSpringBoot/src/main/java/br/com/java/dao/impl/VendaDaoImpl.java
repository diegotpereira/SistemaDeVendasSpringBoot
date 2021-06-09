package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.DaoGenerico;
import br.com.java.dao.VendaDao;
import br.com.java.model.Venda;

@Repository
public class VendaDaoImpl extends DaoGenerico<Venda, Long> implements VendaDao {

}
