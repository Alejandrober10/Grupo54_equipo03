package com.example.file.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.file.csv.Productos;
import com.example.file.interfaceServices.ClienteService;
import com.example.file.interfaces.ClienteDao;
import com.example.file.interfaces.IFacturaDao;
import com.example.file.interfaces.IProductoDao;
import com.example.file.model.Cliente;
import com.example.file.model.Factura;




@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true) //solo leeme infomacion de la base de datos 
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteDao.findAll(); //retorname una lista de tipo persona
		
		
	}

	@Override
	@Transactional //esto es para que me haga comit o rollback en la base de datos
	public void guardar(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void eliminar(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long idcliente) {
		// TODO Auto-generated method stub
		return clienteDao.findById(idcliente).orElse(null);
	}


	@Override
	@Transactional(readOnly = true)
	public Cliente encontrarCliente(Cliente cliente) {
		return clienteDao.findById(cliente.getIdcliente()).orElse(null);//en caso de que no encuentre el valor devuelveme null		
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Productos> findByNombre(String term) {
		// TODO Auto-generated method stub
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void guardarFactura(Factura factura) {
		facturaDao.save(factura);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Productos findProductosById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}
	
	

}
