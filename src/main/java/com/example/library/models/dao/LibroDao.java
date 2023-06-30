package com.example.library.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.library.models.entities.Libro;

public interface LibroDao extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro, Long> {

	List<Libro> findByGenero(String genero);

	Page<Libro> findByGenero(Pageable pageable, String genero);

	List<Libro> findByAutor(String autor);

	Page<Libro> findByAutor(Pageable pageable, String autor);

}
