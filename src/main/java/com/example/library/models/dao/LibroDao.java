package com.example.library.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.library.models.entities.Libro;

public interface LibroDao extends CrudRepository<Libro, Long> {
	
	List<Libro> findByGenero(String genero);
	List<Libro> findByAutor(String autor);

}
