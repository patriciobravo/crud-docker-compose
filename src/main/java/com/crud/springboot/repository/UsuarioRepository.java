package com.crud.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.springboot.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	 // public Usuario findOneByNombre(String nombre);
	  
	  public Optional<Usuario> findByUsername(String username);
	  
	  public Boolean existsByUsername(String username);
	  
	  

}
