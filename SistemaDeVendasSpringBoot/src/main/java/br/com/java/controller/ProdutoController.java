package br.com.java.controller;

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

import br.com.java.model.Fornecedor;
import br.com.java.model.GRUPO;
import br.com.java.model.Produto;
import br.com.java.model.SUBGRUPO;
import br.com.java.model.UF;
import br.com.java.service.FornecedorService;
import br.com.java.service.ProdutoService;

@Controller
@RequestMapping("/cadastros/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private FornecedorService serv;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		return "cadastros/produto/CadProduto";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto) {
		service.salvar(produto);
		
		return "redirect:/cadastros/produto/cadastrar";
	}
	
	@ModelAttribute("grupos")
	public GRUPO[] getGRUPOs() {
		return GRUPO.values();
	}
	
	@ModelAttribute("subgrupos")
	public SUBGRUPO[] getSUBGRUPOs() {
		return SUBGRUPO.values();
	}
	
	@GetMapping("/consultar")
	public String consultar(ModelMap model) {
		model.addAttribute("produtos", service.buscarTodos());
//		model.addAttribute("listaFornecedor", serv.buscarTodos());
		
		return "cadastros/produto/ConsProduto";
	}
	
	
	@ModelAttribute("listaFornecedor")
	   private String listFornecedor(Model model){
	      model.addAttribute("listaFornecedor", serv.buscarTodos());
	      return "listaFornecedor";
	  	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", service.buscarPorId(id));
		
		return "cadastros/produto/CadProduto";
	}
	
	@PostMapping("/editar")
	public String editar(Produto produto, RedirectAttributes attr) {
		service.editar(produto);
		attr.addFlashAttribute("sucesso", "Produto atualizado com sucesso!.");
		
		return "redirect:/cadastros/produto/cadastrar";
	}
}
