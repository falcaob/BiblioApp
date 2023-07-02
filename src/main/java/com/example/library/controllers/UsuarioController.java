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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.library.models.entities.Usuario;
import com.example.library.services.UsuarioService;
import com.example.library.utils.paginator.PageRender;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuariosListar = usuarioService.listar(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/usuarios/listar", usuariosListar);

		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuariosListar);
		model.addAttribute("page", pageRender);

		return "usuarios/listar-usuarios";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model) {

		List<Usuario> usuariosId = new ArrayList<>();
		usuariosId.add(usuarioService.findById(id));
		Pageable pageRequest = PageRequest.of(0, 1);
		Page<Usuario> usuarios = new PageImpl<>(usuariosId, pageRequest, 1);
		PageRender<Usuario> pageRender = new PageRender<>("/usuarios/listar", usuarios);

		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);

		return "usuarios/listar-usuarios";
	}
	
	@GetMapping("/usuario/{usuario}")
	public String listarPorGenero(@PathVariable String usuario, @RequestParam(defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.findByUsuario(pageRequest, usuario);
		PageRender<Usuario> pageRender = new PageRender<>("/usuario/listar", usuarios);

		model.addAttribute("titulo", "Listado de libros por nombre de usuario");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);

		return "usuarios/listar-usuarios";
	}
	
	

}
