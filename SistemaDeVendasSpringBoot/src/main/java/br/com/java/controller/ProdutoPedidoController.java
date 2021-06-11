package br.com.java.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.model.Produto;
import br.com.java.model.ProdutoPedido;
import br.com.java.model.Cliente;
import br.com.java.service.ClienteService;
import br.com.java.service.ProdutoService;
import br.com.java.service.ProdutoPedidoService;

@Controller
@RequestMapping("/produtosPedidos")
public class ProdutoPedidoController {

	@Autowired
	ProdutoPedidoService produtoPedidoService;

	@Autowired
	ProdutoService serviceProduto;

	@Autowired
	ClienteService serviceCliente;

	private List<ProdutoPedido> listaProdutosPedido = new ArrayList<>();

	Produto produto = new Produto();

	private ProdutoPedido produtoPedido = new ProdutoPedido();

	@GetMapping("/cadastrar")
	public String cadastrar(ProdutoPedido produtoPedido, Model model) {
		model.addAttribute("produto", produto);
		return "produto_pedido/cadastroProdutoPedido";
	}

	@PostMapping("/salvar")
	public String salvar(ProdutoPedido produtoPedido, RedirectAttributes attr) {
		produtoPedidoService.salvar(produtoPedido);
		attr.addFlashAttribute("sucesso", "Venda cadastrada com sucesso!.");

		return "redirect:/produtos/pedido/listar";
	}

	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("produtosPedidos", produtoPedidoService.buscarTodos());

		return "produto_pedido/consultar";
	}

	@PostMapping("/adicionarProduto")
	public String adicionarProduto(Produto produto, BigDecimal precoVenda, int quantidade, RedirectAttributes attr) {
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setProduto(produto);
		produtoPedido.setPrecoUnitario(precoVenda);
		produtoPedido.setQuantidade(quantidade);
		listaProdutosPedido.add(produtoPedido);
		attr.addFlashAttribute("sucesso", "Produto adicionado com sucesso!.");

		return "redirect:/produtosPedidos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedidosProduto", produtoPedidoService.buscarPorId(id));

		return "produto_pedido/cadastroProdutoPedido";
	}

	@PostMapping("/editar")
	public String editar(ProdutoPedido produtoPedido, RedirectAttributes attr) {
		produtoPedidoService.editar(produtoPedido);
		attr.addFlashAttribute("sucesso", "Pedido atualizado com sucesso");

		return "redirect:/produtosPedidos/consultar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		produtoPedidoService.excluir(id);

		return "redirect:/produtosPedidos/consultar";
	}

	@GetMapping("/removerProduto/{id}")
	public String removerProduto(@PathVariable("id") Long id, RedirectAttributes attr) {
		listaProdutosPedido.remove(produtoPedido);
		attr.addFlashAttribute("sucesso", "Produto removido com sucesso!.");

		return "redirect:/cadastros/pedido/cadastrar";
	}

	@ModelAttribute("produtos")
	public List<Produto> listaDeProdutos() {
		return serviceProduto.buscarTodos();
	}

	@ModelAttribute("Clientes")
	public List<Cliente> listaDeClientes() {
		return serviceCliente.buscarTodos();
	}

	@ModelAttribute("listaProdutosAdicionados")
	public List<ProdutoPedido> getListaProdutosPedido() {
		return listaProdutosPedido;
	}

	public void setListaProdutosPedido(List<ProdutoPedido> listaProdutosPedido) {
		this.listaProdutosPedido = listaProdutosPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoPedido getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutoPedido produtoPedido) {
		this.produtoPedido = produtoPedido;
	}
}