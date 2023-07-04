package com.example.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.models.dao.UsuarioDao;
import com.example.library.models.entities.User;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	@Transactional 
	public List<User> listar() {
		return (List<User>)usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Page<User> listar(Pageable pageable) {
		return usuarioDao.findAll(pageable);
	}

	@Override
	@Transactional
	public List<User> findByUsuario(String usuario) {
		return usuarioDao.findByUsuario(usuario);
	}

	@Override
	@Transactional
	public Page<User> findByUsuario(Pageable pageable, String usuario) {
		return usuarioDao.findByUsuario(pageable, usuario);
	}

	@Override
	@Transactional
	public User findById(Long id) {
		// optional
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public void save(User usuario) {
		usuarioDao.save(usuario);
		
	}

}
