package com.rodrigo.zup.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rodrigo.zup.domain.Cliente;
import com.rodrigo.zup.domain.NumeroAposta;

public class ClienteNewApostaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String email; 
	private List<String> numerosSorteados= new ArrayList(); 
	
	public ClienteNewApostaDTO(){}
	
	public ClienteNewApostaDTO(Cliente cliente) {
		this.email = cliente.getEmail(); 
		ConvertNumbers(cliente); 
	}
	
	private void ConvertNumbers(Cliente cliente) {
		List<NumeroAposta> numeroApostas = cliente.getApostas().get(0).getNumerosAposta(); 
		for(NumeroAposta num: numeroApostas) {
			this.numerosSorteados.add(num.getNumero()); 
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getNumerosSorteados() {
		return numerosSorteados;
	}

	public void setNumerosSorteados(List<String> numerosSorteados) {
		this.numerosSorteados = numerosSorteados;
	}
	
}
