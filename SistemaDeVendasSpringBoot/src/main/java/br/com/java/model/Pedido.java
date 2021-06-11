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
	
	private String codigoVenda;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dataPedido", nullable = false, columnDefinition = "DATE")
	private LocalDate dataPedido;
	
//	@Column(name = "formaPagamento", nullable = false, length = 50)
//	@Enumerated(EnumType.STRING)
//	private Pagamento formaPagamento;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal desconto;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario_fk")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido")
	private List<ProdutoPedido> listaDeProdutos;
	
	public String getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(String codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

//	public Pagamento getFormaPagamento() {
//		return formaPagamento;
//	}
//
//	public void setFormaPagamento(Pagamento formaPagamento) {
//		this.formaPagamento = formaPagamento;
//	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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

	public List<ProdutoPedido> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<ProdutoPedido> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}
}
