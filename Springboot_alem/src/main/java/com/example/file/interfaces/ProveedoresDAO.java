package com.example.file.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.file.model.Proveedores;

@Repository
public interface ProveedoresDAO extends CrudRepository<Proveedores, Integer>{

}
