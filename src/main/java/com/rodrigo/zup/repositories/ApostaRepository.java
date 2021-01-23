package com.rodrigo.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigo.zup.domain.Aposta;
import com.rodrigo.zup.domain.Cliente;



@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Integer>{

}
