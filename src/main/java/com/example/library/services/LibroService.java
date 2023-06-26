package com.example.library.services;

import java.util.List;

import com.example.library.models.entities.Libro;

public interface LibroService {
	
	List<Libro> listar();
	
	Libro findById(Long id);
	
	List<Libro> findByGenero(String genero);
	
	List<Libro> findByAutor(String autor);
	
	void delete(Long id);
	
	void delete(Libro libro);

}
