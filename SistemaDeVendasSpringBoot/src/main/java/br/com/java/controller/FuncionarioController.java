package br.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastros/funcionario")
public class FuncionarioController {
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "cadastros/funcionario/CadFuncionario";
	}
	
	@GetMapping("consultar")
	public String consultar() {
		return "cadastros/funcionario/CadFuncionario";
	}
}
