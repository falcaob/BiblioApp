package com.example.library.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.example.library.models.entities.User;

public interface UsuarioDao extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
	
	List<User> findByUsuario(String usuario);
	
	Page<User> findByUsuario(Pageable pageable, String usuario);

}
