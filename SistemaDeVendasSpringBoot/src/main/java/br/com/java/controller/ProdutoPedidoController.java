package br.com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.model.Venda;
import br.com.java.service.ClienteService;
import br.com.java.service.ProdutoService;
import br.com.java.service.VendaService;

@Controller
@RequestMapping("/cadastros/venda")
public class VendasController {

	@Autowired
	private ProdutoService serviceProduto;
	
	@Autowired
	private ClienteService serviceCliente;
	
	@Autowired
	private VendaService serviceVenda;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Venda venda) {
		return "cadastros/venda/CadVenda";
	}
	
	@PostMapping("/salvar")
	public String salvar(Venda venda, RedirectAttributes attr) {
		serviceVenda.salvar(venda);
		attr.addFlashAttribute("sucesso", "Venda cadastrada com sucesso!.");
		
		return "redirect:/cadastros/venda/cadastrar";
	}

	@GetMapping("/vendas")
	public String vendas() {
		return "vendas";
	}
	
	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("vendas", serviceVenda.buscarTodos());
		
		return "cadastros/venda/ConVenda";
	}
	
	@ModelAttribute("listarClientes")
	private String listaCliente(Model model) {
		model.addAttribute("listarClientes", serviceCliente.buscarTodos());
		return "listarClientes";
	}

	@ModelAttribute("listarProdutos")
	private String listaProduto(Model model) {
		model.addAttribute("listarProdutos", serviceProduto.buscarTodos());
		return "listarProdutos";
	}
}
