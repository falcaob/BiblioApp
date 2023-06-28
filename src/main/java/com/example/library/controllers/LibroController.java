package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library.services.LibroService;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	LibroService libroService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libroService.listar());
		return "libros/listar-libro";
	}

}
