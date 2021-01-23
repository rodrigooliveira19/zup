package com.rodrigo.zup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rodrigo.zup.domain.Aposta;
import com.rodrigo.zup.domain.Cliente;
import com.rodrigo.zup.domain.NumeroAposta;
import com.rodrigo.zup.repositories.ApostaRepository;
import com.rodrigo.zup.repositories.ClienteRepository;
import com.rodrigo.zup.repositories.NumeroApostaRepository;

@SpringBootApplication
public class ZupApplication implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ApostaRepository apostaRepository;
	@Autowired
	private NumeroApostaRepository numeroApostaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ZupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new  Cliente(null, "oliveirarodrigo191@yahoo.com.br"); 
		Aposta a1 = new Aposta(null,c1); 
		NumeroAposta n1 = new NumeroAposta(null,1,a1); 
		NumeroAposta n2 = new NumeroAposta(null,2,a1); 
		NumeroAposta n3 = new NumeroAposta(null,3,a1); 
		NumeroAposta n4 = new NumeroAposta(null,4,a1); 
		NumeroAposta n5 = new NumeroAposta(null,5,a1); 
		NumeroAposta n6 = new NumeroAposta(null,6,a1); 
		a1.getNumerosAposta().addAll(Arrays.asList(n1,n2,n3,n4,n5,n6)); 
		c1.getApostas().add(a1); 
		
		this.clienteRepository.save(c1); 
		this.apostaRepository.save(a1); 
		this.numeroApostaRepository.saveAll(Arrays.asList(n1,n2,n3,n4,n5,n6)); 
		
		
	}
		

}
