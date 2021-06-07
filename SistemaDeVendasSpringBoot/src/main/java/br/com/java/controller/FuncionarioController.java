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

import br.com.java.model.Funcionario;
import br.com.java.model.UF;
import br.com.java.service.FuncionarioService;

@Controller
@RequestMapping("/cadastros/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "cadastros/funcionario/CadFuncionario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario) {
		service.salvar(funcionario);
		
		return "redirect:/cadastros/funcionario/cadastrar";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		
		return UF.values();
	}
	
	@GetMapping("consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("funcionarios", service.buscarTodos());
		return "cadastros/funcionario/ConsFuncionario";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", service.buscarPorId(id));
		
		return "cadastros/funcionario/CadFuncionario";
	}
	
	@PostMapping("/editar")
	public String editar(Funcionario funcionario, RedirectAttributes attr) {
		service.editar(funcionario);
		attr.addFlashAttribute("sucesso", "Funcionário atualizado com sucesso!.");
		
		return "redirect:/cadastros/funcionario/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		service.excluir(id);
		
		return "redirect:/cadastros/funcionario/consultar";
	}
}
