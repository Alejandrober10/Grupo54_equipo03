package com.example.file.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.file.model.Usuarios;


@Repository
public interface UserRepository extends CrudRepository<Usuarios, Long>  {
    public Optional<Usuarios> findByUsername(String username);
}