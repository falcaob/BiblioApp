package com.example.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("titulo", "¡Bienvenido!");
		model.addAttribute("titulo1", "Ver listado de libros");
		model.addAttribute("titulo2", "Ver usuarios de la biblioteca");
		
		return "home";
	}

}
