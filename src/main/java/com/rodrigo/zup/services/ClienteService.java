package com.rodrigo.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.zup.domain.Cliente;
import com.rodrigo.zup.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo; 
	
	public Cliente findByEmail(String email) {
		Cliente obj = repo.findByEmail(email); 
		return obj; 
	}
}
