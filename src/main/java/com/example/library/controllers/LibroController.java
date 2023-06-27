package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library.services.LibroService;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	LibroService libroService;
	
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("titulo", "Listado de libros");
		return "libro";
	}

}
