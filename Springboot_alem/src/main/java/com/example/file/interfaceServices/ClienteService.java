package com.example.file.interfaceServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.file.csv.Productos;
import com.example.file.model.Cliente;
import com.example.file.model.Factura;

public interface ClienteService {

	public List<Cliente> listarClientes();
	
	public void guardar(Cliente cliente);
	
	public void eliminar(Cliente cliente);
	
	public Cliente encontrarCliente(Cliente cliente);
	
	public Cliente findOne(Long idcliente);
	
	public List<Productos> findByNombre(String term);
	
	public void guardarFactura (Factura factura);
	
	public Productos findProductosById(Long itemId);
	
}
