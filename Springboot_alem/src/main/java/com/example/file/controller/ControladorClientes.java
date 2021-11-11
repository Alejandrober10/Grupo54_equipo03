package com.example.file.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.file.interfaceServices.ClienteService;
import com.example.file.model.Cliente;

@Controller
@RequestMapping
public class ControladorClientes {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/listarCliente")
	public String inicio(Model model) {
		var clientes = clienteService.listarClientes(); //var.. Identifica el tipo de dato
		model.addAttribute("clientes", clientes);
		return "clientes";
	}
	
	@GetMapping("/agregarCliente")
	public String agregar(Cliente cliente) {
		return "nuevoCliente";
		
	}
	
	@PostMapping("/guardarCliente")
	public String guardar(Cliente cliente) {
		clienteService.guardar(cliente);
		return "redirect:/listarCliente";  //enviame nuevamente a la pagina de inicio
	}
	
	@GetMapping("/editarCliente/{idcliente}")
	public String editar(Cliente cliente,Model model) {//no es necesario inicializar el objeto
		cliente = clienteService.encontrarCliente(cliente);
		model.addAttribute("cliente", cliente);
		return "nuevoCliente";
	}
	
	@GetMapping("/eliminarCliente/{idcliente}")
	public String eliminar(Cliente cliente) {
		clienteService.eliminar(cliente);
		return "redirect:/listarCliente";
	}		
	}  
