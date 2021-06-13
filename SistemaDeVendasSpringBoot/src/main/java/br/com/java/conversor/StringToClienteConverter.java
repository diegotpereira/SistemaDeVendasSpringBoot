package br.com.java.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.java.model.Cliente;
import br.com.java.service.ClienteService;

@Component
public class StringToClienteConverter implements Converter<String, Cliente> {
	
	@Autowired
	private ClienteService service;

	@Override
	public Cliente convert(String text) {
		// TODO Auto-generated method stub
		
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		
		return service.buscarPorId(id);
	}

}
