package br.com.java.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_produto")
public class Produto  extends AbstractEntity<Long>{
	
	// Código do produto
	private String codigo;

	// Cógigo de barras
	private String ean;

	// Entidade Fornecedor
	@ManyToOne
	@JoinColumn(name = "idFornecedor")
	private Fornecedor fornecedor;


	private String descricao;
	private String unidade;
	private String dataEntrada;
	private String grupo;
	private String subGrupo;
	private String imagem;
	
	@Column(name="preco_custo", nullable = false)
	private Double precoCusto;
	
	
	@Column(name="preco_venda", nullable = false)
	private Double precoVenda;
	

	
	@OneToMany(mappedBy = "produto")
	List<ProdutoPedido> listaProdutosPedidos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ProdutoPedido> getListaProdutosPedidos() {
		return listaProdutosPedidos;
	}

	public void setListaProdutosPedidos(List<ProdutoPedido> listaProdutosPedidos) {
		this.listaProdutosPedidos = listaProdutosPedidos;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
}
