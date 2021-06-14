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
	
	

    /**
     * @return String return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente = cliente.getNome();
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return String return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto = produto.getDescricao();
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

}
