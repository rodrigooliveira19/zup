package com.rodrigo.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.zup.domain.NumeroAposta;



@Repository
public interface NumeroApostaRepository extends JpaRepository<NumeroAposta, Integer>{

}
