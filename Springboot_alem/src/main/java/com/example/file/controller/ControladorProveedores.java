package com.example.file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.file.interfaceServices.IProveedoresService;
import com.example.file.model.Proveedores;

@Controller
@RequestMapping
public class ControladorProveedores {
	
	@Autowired
	private IProveedoresService serviceP;
	
	@GetMapping("/listarProveedor")
	public String listar(Model model) {
		List<Proveedores> p = serviceP.listarProveedores();
		model.addAttribute("proveedores", p);
		return "proveedores";
	}
	
	@GetMapping("/agregarProveedor")
	public String agregar(Proveedores p) {
		return "nuevoP";
		
	}
	
	@PostMapping("/guardarProveedor")
	public String guardar(Proveedores p) {
		serviceP.guardarP(p);
		return "redirect:/listarProveedor";  //enviame nuevamente a la pagina de inicio
	}
	
	@GetMapping("/editarProveedor/{idproveedor}")
	public String editar(Proveedores p,Model model) {//no es necesario inicializar el objeto
		p = serviceP.encontrarP(p);
		model.addAttribute("proveedores", p);
		return "nuevoP";
	}
	
	@GetMapping("/eliminarProveedor/{idproveedor}")
	public String eliminar(Proveedores p) {
		serviceP.eliminarP(p);
		return "redirect:/listarProveedor";
	}
	

}
