package br.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.model.Cliente;
import br.com.java.model.Produto;
import br.com.java.model.Venda;
import br.com.java.service.ClienteService;
import br.com.java.service.ProdutoService;
import br.com.java.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendasController {

	@Autowired
	ClienteService serviceCliente;

	@Autowired
	ProdutoService serviceProduto;

	@Autowired
	VendaService serviceVenda;

	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("venda") Venda venda) {
		return "/vendas/CadVenda";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("venda") Venda venda, RedirectAttributes attr) {
		serviceVenda.salvar(venda);
		attr.addFlashAttribute("sucesso", "Venda cadastrada com sucesso!.");
		
		return "redirect:/vendas/cadastrar";
	}

	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("vendas", serviceVenda.buscarTodos());
		
		return "vendas/ConVenda";
		
	}
	// Lista de Clientes
	@ModelAttribute("clientes")
	public List<Cliente> listaDeClientes() {
		return serviceCliente.buscarTodos();
	}

	// Lista de Produtos
	@ModelAttribute("produtos")
	public List<Produto> listaDeProdutos() {

		return serviceProduto.buscarTodos();
	}
}
