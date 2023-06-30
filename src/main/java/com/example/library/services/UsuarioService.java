package com.example.library.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.library.models.entities.Usuario;

public interface UsuarioService {

	List<Usuario> listar();

	Page<Usuario> listar(Pageable pageable);

	List<Usuario> findByUsuario(String usuario);

	Page<Usuario> findByUsuario(Pageable pageable, String usuario);

}
