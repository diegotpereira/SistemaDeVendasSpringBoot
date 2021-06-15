package br.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {
    
    @GetMapping("/show")
    public String cadastrar() {
        return "/relatorios/exemplojm.jrxml";
    }
}