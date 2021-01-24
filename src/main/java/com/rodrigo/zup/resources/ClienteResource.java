package com.rodrigo.zup.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.zup.domain.Cliente;
import com.rodrigo.zup.domain.dto.ClienteNewApostaDTO;
import com.rodrigo.zup.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@RequestMapping( method = RequestMethod.GET)
	public String hola() {
		return "Hola Zup."; 
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByEmail(@PathVariable String email) {
		Cliente obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.POST)
	public ResponseEntity<ClienteNewApostaDTO> createBetByEmail(@PathVariable String email) {
		ClienteNewApostaDTO obj =  service.createBetByEmail(email); 
		return ResponseEntity.ok().body(obj); 
	}
}
