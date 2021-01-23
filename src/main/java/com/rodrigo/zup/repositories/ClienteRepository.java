package com.rodrigo.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigo.zup.domain.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//Spring retorma um  cliente buscando pelo campo email. 
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);

}
