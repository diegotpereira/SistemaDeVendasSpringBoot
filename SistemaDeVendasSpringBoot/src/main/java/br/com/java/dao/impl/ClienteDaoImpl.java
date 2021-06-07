package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.ClienteDao;
import br.com.java.dao.DaoGenerico;
import br.com.java.model.Cliente;

@Repository
public class ClienteDaoImpl extends DaoGenerico<Cliente, Long> implements ClienteDao {
}
