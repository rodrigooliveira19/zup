package com.rodrigo.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.zup.domain.Aposta;
import com.rodrigo.zup.domain.Cliente;
import com.rodrigo.zup.domain.NumeroAposta;
import com.rodrigo.zup.domain.dto.ClienteNewApostaDTO;
import com.rodrigo.zup.repositories.ApostaRepository;
import com.rodrigo.zup.repositories.ClienteRepository;
import com.rodrigo.zup.repositories.NumeroApostaRepository;
import com.rodrigo.zup.services.utils.GeradorDeNumeros;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo; 
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@Autowired
	private NumeroApostaRepository numeroApostaRepository;
	
	public Cliente findByEmail(String email) {
		Cliente obj = repo.findByEmail(email); 
		return obj; 
	}
	
	public ClienteNewApostaDTO createBetByEmail(String email) {
		if(!email.isEmpty()) {
			Cliente obj = repo.findByEmail(email); 
			if(obj != null) {
				Cliente auxCli = new Cliente(obj.getId(),obj.getEmail()); 
				createNumbersAposta(auxCli); 
				apostaRepository.save(auxCli.getApostas().get(0)); 
				numeroApostaRepository.saveAll(auxCli.getApostas().get(0).getNumerosAposta()); 
				ClienteNewApostaDTO objDTO = fromDTO(auxCli);
				
				return objDTO; 
			}
		}
		
		return null; 
	}
	
	private void createNumbersAposta(Cliente auxCli ) {
		GeradorDeNumeros gerador = new GeradorDeNumeros(); 
		List<String> numerosSorteados = gerador.gerarNumeros(6); 
		Aposta aposta = new Aposta(null, auxCli); 
		for(String num: numerosSorteados) {
			aposta.getNumerosAposta().add(new NumeroAposta(null,num,aposta)); 
		}
		
		auxCli.getApostas().add(aposta); 
	}
	
	private ClienteNewApostaDTO fromDTO(Cliente auxCli) {
		return new ClienteNewApostaDTO(auxCli); 
	}
}
