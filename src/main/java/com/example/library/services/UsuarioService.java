package com.example.library.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.library.models.entities.Libro;
import com.example.library.models.entities.User;

public interface UsuarioService {

	List<User> listar();

	Page<User> listar(Pageable pageable);

	List<User> findByUsuario(String usuario);

	Page<User> findByUsuario(Pageable pageable, String usuario);
	
	User findById(Long id);
	
	void delete(Long id);
	
	void save(User usuario);

}
