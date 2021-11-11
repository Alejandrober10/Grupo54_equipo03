package com.example.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ControladorReportes {
	
	@GetMapping("/reportes")
	public String inicio(Model model) {
		return "reporte";
	}

}
