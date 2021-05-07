package com.gft.imob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.imob.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{

	Usuario findByLogin(String login);
	
}
