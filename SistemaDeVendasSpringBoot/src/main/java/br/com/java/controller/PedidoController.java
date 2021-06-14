package br.com.java.controller;

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
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService servicePedido;

	@Autowired
	ProdutoService serviceProduto;
	
	@Autowired
	ClienteService serviceCliente;

	Produto produto = new Produto();

	@GetMapping("/cadastrar")
	public String cadastrar(Pedido pedido) {
		return "/pedido/cadastroPedido";
	}

	@PostMapping("/salvar")
	public String salvar(Pedido pedido, Produto produto, RedirectAttributes attr, ModelMap model) {
//		model.addAttribute("produto", produto);
		servicePedido.salvar(pedido);
		attr.addFlashAttribute("sucesso", "Pedido cadastrado com sucesso!.");

		return "redirect:/pedidos/cadastrar";
	}

	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("pedidos", servicePedido.buscarTodos());
		
		return "/pedido/lista";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedidos", servicePedido.buscarPorId(id));

		return "/pedido/cadastroPedido";
	}

	@PostMapping("/editar")
	public String editar(Pedido pedido, RedirectAttributes attr) {
		servicePedido.editar(pedido);
		attr.addFlashAttribute("sucesso", "Pedido atualizado com sucesso");

		return "redirect:/pedidos/consultar";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarDados(@PathVariable("id")Long id, ModelMap model) {
		model.addAttribute("buscarDados", serviceProduto.buscarPorId(id));
		
		return "buscarDados";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		servicePedido.excluir(id);

		return "redirect:/pedidos/consultar";
	}
	
	// Lista de Produtos
	@ModelAttribute("produtos")
	public List<Produto> listaDeProdutos() {

		return serviceProduto.buscarTodos();
	}

	// Lista de Clientes
	@ModelAttribute("clientes")
	public List<Cliente> listaDeClientes() {
		return serviceCliente.buscarTodos();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
