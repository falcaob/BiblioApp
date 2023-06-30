package com.example.library.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.example.library.models.entities.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>, CrudRepository<Usuario, Long> {
	
	List<Usuario> findByUsuario(String usuario);
	
	Page<Usuario> findByUsuario(Pageable pageable, String usuario);

}
