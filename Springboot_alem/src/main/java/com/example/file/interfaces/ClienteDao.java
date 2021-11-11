package com.example.file.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.file.model.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long> {
	//CREA UNA IMPLEMENTACION POR DEFAULT SPRING 
	
}
