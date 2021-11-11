package com.example.file.csv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;


@Repository //Realiza operaciones CRUD
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}

