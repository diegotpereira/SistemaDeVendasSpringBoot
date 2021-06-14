package br.com.java.model;

import javax.persistence.*;
import java.lang.String;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_vendas")
public class Venda extends AbstractEntity<Long> {
	
//    private String codigoVenda;
	
	@ManyToOne
	@JoinColumn(name ="idCliente")
	private Cliente cliente;
	private String nome_cliente;
	
	@ManyToOne
	@JoinColumn(name ="idProduto")
	private Produto produto;
	private String nome_produto;
	
	private Integer quantidade;

//	public String getCodigoVenda() {
//		return codigoVenda;
//	}
//
//	public void setCodigoVenda(String codigoVenda) {
//		this.codigoVenda = codigoVenda;
//	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
