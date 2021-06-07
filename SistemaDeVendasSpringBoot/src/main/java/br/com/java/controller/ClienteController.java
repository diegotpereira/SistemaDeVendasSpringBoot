package br.com.java.controller;

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
import br.com.java.model.UF;
import br.com.java.service.ClienteService;

@Controller
@RequestMapping("/cadastros/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "cadastros/cliente/CadCliente";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		service.salvar(cliente);
		attr.addFlashAttribute("sucesso", "Cliente cadastrado com sucesso!.");
		
		return "redirect:/cadastros/cliente/cadastrar";
	}
	
	@ModelAttribute("ufs")
	public UF[]getUFS(){
		return UF.values();
	}
	
	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("clientes", service.buscarTodos());
		return "cadastros/cliente/ConCliente";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", service.buscarPorId(id));
		
		return "cadastros/cliente/CadCliente";
	}
	
	@PostMapping("/editar")
	public String editar(Cliente cliente, RedirectAttributes attr) {
		service.editar(cliente);
		attr.addFlashAttribute("sucesso", "Cliente atualizado com sucesso!.");
		return "redirect:/cadastros/cliente/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
		service.excluir(id);
		attr.addFlashAttribute("sucesso", "Cliente excluido com sucesso!");

		return "redirect:/cadastros/cliente/consultar";
	}
}
