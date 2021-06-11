package br.com.java.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.dao.ProdutoPedidoDao;
import br.com.java.dao.DaoGenerico;
import br.com.java.model.ProdutoPedido;
@Repository
public class ProdutoPedidoDaoImpl extends DaoGenerico<ProdutoPedido, Long> implements ProdutoPedidoDao{

}
