package com.example.file.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.file.model.Usuarios;

@Repository
public interface IUsuarios extends CrudRepository<Usuarios, Integer>{

}
