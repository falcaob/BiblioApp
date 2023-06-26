package com.example.library.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.models.entities.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Override
	public List<Libro> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> findByGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> findByAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Libro libro) {
		// TODO Auto-generated method stub
		
	}

}
