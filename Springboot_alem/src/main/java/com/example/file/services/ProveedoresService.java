package com.example.file.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.file.interfaceServices.IProveedoresService;
import com.example.file.interfaces.ProveedoresDAO;
import com.example.file.model.Proveedores;

@Service
public class ProveedoresService implements IProveedoresService{
	
	@Autowired
	ProveedoresDAO dao;

	@Override
	public List<Proveedores> listarProveedores() {
		return (List<Proveedores>)dao.findAll();		
	}

	@Override
	public void guardarP(Proveedores p) {
		dao.save(p);		
	}

	@Override
	public void eliminarP(Proveedores p) {
		dao.delete(p);		
	}

	@Override
	public Proveedores encontrarP(Proveedores p) {
		return dao.findById(p.getIdproveedor()).orElse(null);
		
	}

}
