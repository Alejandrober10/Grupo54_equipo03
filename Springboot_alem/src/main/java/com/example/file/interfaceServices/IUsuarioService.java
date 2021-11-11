package com.example.file.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.example.file.model.Usuarios;

public interface IUsuarioService {
	public List<Usuarios>listar();
	public Optional<Usuarios>listarId(int id);
	public int save(Usuarios u);
	public void delete(int i);

}
