package com.example.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.models.dao.UsuarioDao;
import com.example.library.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	@Transactional 
	public List<Usuario> listar() {
		return (List<Usuario>)usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Page<Usuario> listar(Pageable pageable) {
		return usuarioDao.findAll(pageable);
	}

	@Override
	@Transactional
	public List<Usuario> findByUsuario(String usuario) {
		return usuarioDao.findByUsuario(usuario);
	}

	@Override
	@Transactional
	public Page<Usuario> findByUsuario(Pageable pageable, String usuario) {
		return usuarioDao.findByUsuario(pageable, usuario);
	}

}
