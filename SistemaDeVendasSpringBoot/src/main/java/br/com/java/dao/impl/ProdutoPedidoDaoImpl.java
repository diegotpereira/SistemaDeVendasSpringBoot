package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.PedidoDao;
import br.com.java.dao.DaoGenerico;
import br.com.java.model.Pedido;
@Repository
public class PedidoDaoImpl extends DaoGenerico<Pedido, Long> implements PedidoDao{

}
