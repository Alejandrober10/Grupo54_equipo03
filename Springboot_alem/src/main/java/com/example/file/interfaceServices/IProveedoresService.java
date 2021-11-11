package com.example.file.interfaceServices;

import java.util.List;

import com.example.file.model.Proveedores;

public interface IProveedoresService {
	
	public List<Proveedores> listarProveedores();
	public void guardarP(Proveedores p);	
	public void eliminarP(Proveedores p);	
	public Proveedores encontrarP(Proveedores p);
	

}