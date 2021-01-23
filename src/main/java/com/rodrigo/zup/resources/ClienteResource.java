package com.rodrigo.zup.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@RequestMapping( method = RequestMethod.GET)
	public String hola() {
		return "Hola Zup."; 
	}
}
