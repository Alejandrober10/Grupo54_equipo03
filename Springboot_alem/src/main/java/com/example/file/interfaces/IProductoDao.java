package com.example.file.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.file.csv.Productos;

@Repository
public interface IProductoDao extends CrudRepository<Productos, Long> {
	//CREA UNA IMPLEMENTACION POR DEFAULT SPRING 
	
	@Query("select p from Productos p where p.nombre like %?1%")//cuando nombre sea igual a term de jquery
	//public List<Productos> findByNombre(String term)
	public List<Productos> findByNombreLikeIgnoreCase(String term); //ignora mayusculas y minusculas
}
