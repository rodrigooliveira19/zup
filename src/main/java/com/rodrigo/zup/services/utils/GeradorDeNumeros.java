package com.rodrigo.zup.services.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class GeradorDeNumeros {

	private List<String> numerosSorteados= new ArrayList<>(); 
	
	public GeradorDeNumeros() {
		
	}
	
	public  List<String> gerarNumeros(int qtd){
		for(int i=0; numerosSorteados.size() < qtd; i++) {
			Random random = new Random(); 
			String num  = Integer.toString(random.nextInt(100)); 
			if(!numerosSorteados.contains(num)) {
				numerosSorteados.add(num); 
			}
		}
		return numerosSorteados; 
	}
}
