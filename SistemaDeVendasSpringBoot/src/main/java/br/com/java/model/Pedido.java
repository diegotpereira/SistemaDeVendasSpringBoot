	package br.com.java.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_pedidos")
public class Pedido extends AbstractEntity<Long>{
	
	// Código da Venda
	private String codigoVenda;

	// Entidade Funcionario
	@ManyToOne
	@JoinColumn(name = "id_funcionario_fk")
	private Funcionario funcionario;

	// Entidade Cliente
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;

	// Entidade Produto
	@ManyToOne
	@OneToMany(mappedBy = "idProduto")
	private Produto produto;

	// Preço de Custo
	@Column(name = "precoCusto", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	public BigDecimal precoCusto;


	// Preço de Venda
	@NumberFormat(style = Style.CURRENCY, pattern = "#.##0,00")
	@Column(name="precoVenda", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal precoVenda;

	// Valor de Desconto
	@NumberFormat(style = Style.CURRENCY, pattern = "#.##0,00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal desconto;

	// Data do Pedido
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dataPedido", nullable = true, columnDefinition = "DATE")
	private LocalDate dataPedido;
	
//	@Column(name = "formaPagamento", nullable = false, length = 50)
//	@Enumerated(EnumType.STRING)
//	private Pagamento formaPagamento;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = true, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal valorTotal;
	
	// Lista de Produtos
	@OneToMany(mappedBy = "pedido")
	private List<ProdutoPedido> listaDeProdutos;

	public String getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(String codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

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

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ProdutoPedido> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<ProdutoPedido> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

}