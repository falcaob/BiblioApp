package com.example.library.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.library.utils.paginator.*;

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


import com.example.library.models.entities.Libro;
import com.example.library.services.LibroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	LibroService libroService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> librosListar = libroService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libros/listar", librosListar); 
		
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", librosListar);
		model.addAttribute("page", pageRender);
		
		return "libros/listar-libros";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model) {
		
		List<Libro>librosId = new ArrayList<>();
		librosId.add(libroService.findById(id));
		Pageable pageRequest = PageRequest.of(0, 1);
		Page<Libro> libros = new PageImpl<>(librosId, pageRequest, 1);
		PageRender<Libro> pageRender = new PageRender<>("/libros/listar", libros); 

		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		
        return "libros/listar-libros";
	}
	
	@GetMapping("/autor/{autor}")
	public String listarPorAutor(@PathVariable String autor, @RequestParam(defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.findByAutor(pageRequest, autor);
		PageRender<Libro> pageRender = new PageRender<>("/libros/listar", libros);
		
		model.addAttribute("titulo", "Listado de libros por autor");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		
        return "libros/listar-libros";
	}
	
	@GetMapping("/genero/{genero}")
	public String listarPorGenero(@PathVariable String genero, @RequestParam(defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.findByGenero(pageRequest, genero);
		PageRender<Libro> pageRender = new PageRender<>("/libros/listar", libros);
		
		model.addAttribute("titulo", "Listado de libros por género");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		
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
	
	@PostMapping("/form")
	public String guardar(@Valid Libro libro, BindingResult result, Model model, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de un libro");
			return "libros/form"; 
		}
		libroService.save(libro);
		flash.addFlashAttribute("success", "Libro guardado con éxito");
		return "redirect:listar";
	}
}
