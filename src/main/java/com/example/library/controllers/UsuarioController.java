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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.library.models.entities.User;
import com.example.library.services.UsuarioService;
import com.example.library.utils.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<User> usuariosListar = usuarioService.listar(pageRequest);
		PageRender<User> pageRender = new PageRender<>("/usuarios/listar", usuariosListar);

		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuariosListar);
		model.addAttribute("page", pageRender);

		return "usuarios/listar-usuarios";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model) {

		List<User> usuariosId = new ArrayList<>();
		usuariosId.add(usuarioService.findById(id));
		Pageable pageRequest = PageRequest.of(0, 1);
		Page<User> usuarios = new PageImpl<>(usuariosId, pageRequest, 1);
		PageRender<User> pageRender = new PageRender<>("/usuarios/listar", usuarios);

		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);

		return "usuarios/listar-usuarios";
	}
	
	@GetMapping("/usuario/{usuario}")
	public String listarPorGenero(@PathVariable String usuario, @RequestParam(defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<User> usuarios = usuarioService.findByUsuario(pageRequest, usuario);
		PageRender<User> pageRender = new PageRender<>("/usuario/listar", usuarios);

		model.addAttribute("titulo", "Listado de libros por nombre de usuario");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);

		return "usuarios/listar-usuarios";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id, Model model, RedirectAttributes flash) {

		model.addAttribute("titulo", "Listado de Artículos");
		usuarioService.delete(id);
		model.addAttribute("usuarios", usuarioService.listar());

		flash.addFlashAttribute("warning", "Usuario borrado con éxito");

		return "redirect:/usuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {

		model.addAttribute("titulo", "Edición de un usuario");
		model.addAttribute("usuarios", usuarioService.findById(id));
		return "usuarios/form";
	}
	
	// Usuarios+ del nav
	@GetMapping("/editar")
	public String editarNav(Model model) {

		model.addAttribute("titulo", "Edición de un usuario");
		model.addAttribute("usuarios", new User());
		
		return "usuarios/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid User usuario, BindingResult result, Model model, RedirectAttributes flash) {
		
		
		if (result.hasErrors()) {
			model.addAttribute("usuarios", "Edición de un usuario");
			return "usuarios/form";
		}
		
		usuarioService.save(usuario);
		flash.addFlashAttribute("success", "Usuario guardado con éxito");
		return "redirect:listar";
	}
	
	

}
