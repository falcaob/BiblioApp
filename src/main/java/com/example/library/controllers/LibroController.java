package com.example.library.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.library.services.LibroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	LibroService libroService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libroService.listar());
		return "libros/listar-libros";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id, Model model) {
		
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libroService.findById(id));
        return "libros/listar-libros";
	}
	
	@GetMapping("/autor/{autor}")
	public String listarPorAutor(@PathVariable String autor, Model model) {
		
		model.addAttribute("titulo", "Listado de libros por autor");
		model.addAttribute("libros", libroService.findByAutor(autor));
        return "libros/listar-libros";
	}
	
	@GetMapping("/genero/{genero}")
	public String listarPorGenero(@PathVariable String genero, Model model) {
		
		model.addAttribute("titulo", "Listado de libros por género");
		model.addAttribute("libros", libroService.findByGenero(genero));
        return "libros/listar-libros";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id, Model model, RedirectAttributes flash) {
		
		model.addAttribute("titulo", "Listado de Artículos");
		libroService.delete(id);
		model.addAttribute("libros",libroService.listar());
		
		flash.addFlashAttribute("warning", "Libro borrado con éxito");
		
		return "redirect:/libros/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		
		model.addAttribute("titulo", "Edición de un libro");
		model.addAttribute("libro", libroService.findById(id));
		return "libros/form";
	}
	
	/*
	@PostMapping("/form")
	public String guardar(@Valid Articulo articulo, BindingResult result, @RequestParam("file") MultipartFile foto, Model model, RedirectAttributes flash) {
		// la anotación para que se habiliten las validaciones
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de un artículo");
			return "articulos/form";
		}
	}
	*/
}
