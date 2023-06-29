package com.example.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.models.dao.LibroDao;
import com.example.library.models.entities.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDao libroDao;

	@Override
	@Transactional(readOnly = true)
	public List<Libro> listar() {
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Libro findById(Long id) {
		// Optional
		return libroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Libro> findByGenero(String genero) {
		return libroDao.findByGenero(genero);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Libro> findByAutor(String autor) {
		return libroDao.findByAutor(autor);
	}

	@Override
	@Transactional // métodos void no (readOnly = true)
	public void delete(Long id) {
		libroDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		libroDao.save(libro);
	}

}
