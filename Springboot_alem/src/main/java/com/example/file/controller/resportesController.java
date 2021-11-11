package com.example.file.controller;

import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.example.file.interfaceServices.IUsuarioService;
import com.example.file.model.Cliente;
import com.example.file.model.Usuarios;

	@Controller
	@RequestMapping
public class resportesController {
/*
		@Autowired
		private IUsuarioService service;
		private IUsuarioService service;
		
		@GetMapping("/listarClientes")
		public String listarUsuarios(Model model) {
			List<Usuarios> usuarios = service.listar();
			model.addAttribute("usuarios", usuarios);
			return "inicio";
		}
		
		@GetMapping("/listarClientes")
		public String listarClientes(Model model) {
			List<Cliente> clientes = service.listarClientes();
			model.addAttribute("clientes", clientes);
			return "clientes";
		}
		
		@GetMapping("/listarVentas")
		public String listarVentas(Model model) {
			List<Cliente> clientes = service.listarClientes();
			model.addAttribute("clientes", clientes);
			return "reportes";
		}*/

}

