package br.com.java.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.java.model.Produto;
import br.com.java.service.ProdutoService;

@Component
public class StringToProdutoConversor implements Converter<String, Produto>{
	
	@Autowired
	private ProdutoService service;

	@Override
	public Produto convert(String text) {
		// TODO Auto-generated method stub
		
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		
		return service.buscarPorId(id);
	}

}
