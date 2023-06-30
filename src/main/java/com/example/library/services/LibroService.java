package com.example.library.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.library.models.entities.Libro;

public interface LibroService {
	
	List<Libro> listar();
	
	Page<Libro> listar(Pageable pageable);
	
	Libro findById(Long id);
	
	List<Libro> findByGenero(String genero);
	
	Page<Libro> findByGenero(Pageable pageable, String genero);
	
	List<Libro> findByAutor(String autor);
	
	Page<Libro> findByAutor(Pageable pageable, String autor);
	
	void delete(Long id);
	
	void save(Libro libro);

}
