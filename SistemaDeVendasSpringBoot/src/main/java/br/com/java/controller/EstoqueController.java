package br.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {
	
	@GetMapping("/estoque")
	public String estoque() {
		return "estoque/estoque";
	}
}
