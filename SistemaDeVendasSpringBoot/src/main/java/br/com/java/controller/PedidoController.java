package br.com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.model.Cliente;
import br.com.java.model.Pedido;
import br.com.java.model.Produto;
import br.com.java.service.ClienteService;
import br.com.java.service.PedidoService;
import br.com.java.service.ProdutoService;

@Controller
@RequestMapping("/cadastros/pedido")
public class PedidoController {

	@Autowired
	PedidoService servicePedido;

	@Autowired
	ProdutoService serviceProduto;

	@Autowired
	ClienteService serviceCliente;

	Produto produto = new Produto();

	private List<Pedido> listaDePedidos = new ArrayList<>();

	private Pedido pedido = new Pedido();

	@GetMapping("/cadastrar")
	public String cadastrar(Pedido pedido) {
		return "/cadastros/pedido/CadPedido";
	}

	@PostMapping("/salvar")
	public String salvar(Pedido pedido, Produto produto, RedirectAttributes attr) {
		servicePedido.salvar(pedido);
		attr.addFlashAttribute("sucesso", "Pedido cadastrado com sucesso!.");

		return "redirect:/cadastros/pedido/cadastrar";
	}

	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("pedidos", servicePedido.buscarTodos());

		return "/cadastros/pedido/ConPedido";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedido", servicePedido.buscarPorId(id));

		return "cadastros/pedido/CadPedido";
	}

	@PostMapping("/editar")
	public String editar(Pedido pedido, RedirectAttributes attr) {
		servicePedido.editar(pedido);
		attr.addFlashAttribute("sucesso", "Pedido atualizado com sucesso");

		return "redirect:/cadastros/pedido/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		servicePedido.excluir(id);

		return "redirect:/cadastros/pedido/consultar";
	}

	@PostMapping("/adicionarProduto")
	public String adicionarProduto(Produto produto, int quantidade, RedirectAttributes attr) {
		Pedido pedido = new Pedido();

		pedido.setProduto(produto);
		pedido.setQuantidade(quantidade);
		listaDePedidos.add(pedido);
		attr.addFlashAttribute("sucesso", "Produto acidionado com sucesso!.");

		return "redirect:/cadastros/pedido/cadastrar";
	}

	@GetMapping("/removerProduto/{id}")
	public String removerProduto(@PathVariable("id") Long id, RedirectAttributes attr) {
		listaDePedidos.remove(pedido);
		attr.addFlashAttribute("sucesso", "Produto removido com sucesso!.");

		return "redirect:/cadastros/pedido/cadastrar";
	}
	
	// Lista de Produtos
	@ModelAttribute("listaProdutos")
	public List<Produto> listaDeProdutos() {

		return serviceProduto.buscarTodos();
	}
	
	// Lista de Clientes
	@ModelAttribute("listaDeClientes")
	public List<Cliente> listaDeClientes(){
		
		return serviceCliente.buscarTodos();
	}
	
	// Lista de Produtos Adicionados
	@ModelAttribute("listaProdutosAdicionados")
	public List<Pedido> listaDeProdutosPedidos(){
		
		return listaDePedidos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
