package br.com.java.model;

import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_produtos_pedido")
public class ProdutoPedido extends AbstractEntity<Long>{
	
	// Entidade Produto
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id_fk")
	private Produto produto;
	
	// Entidade Pedido
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id_fk")
	private Pedido pedido;
	
	// Preço por Unidade
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "precoUnitario", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	public BigDecimal precoUnitario;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "precoTotal", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal precoTotal;	
	
	@Column(nullable = false)
	private int quantidade;
	
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
