package com.rodrigo.zup.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NumeroAposta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	private int numero; 
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name = "aposta_id")
	private Aposta aposta; 
	
	public NumeroAposta() {
		
	}

	public NumeroAposta(Integer id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
