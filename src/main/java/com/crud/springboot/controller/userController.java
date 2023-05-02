package com.crud.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.springboot.exception.ResouceNotFoundException;
import com.crud.springboot.model.Usuario;
import com.crud.springboot.repository.UsuarioRepository;



@RestController
@RequestMapping("/api")
public class userController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public Usuario addEmployee(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllEmployees() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("usuarios/{id}")
    public ResponseEntity<Usuario> findEmployeeById(@PathVariable(value = "id") Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + usuarioId));
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping("usuarios/{id}")
    public ResponseEntity<Usuario> updateEmployee(@PathVariable(value = "id") Long usuarioId, @RequestBody Usuario usuarioDetalle) {
    	Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResouceNotFoundException("Employee not found for this id :: " + usuarioId));
        usuario.setUsername(usuarioDetalle.getUsername());
        final Usuario updatedEmployee = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedEmployee);

    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Long usuarioId) {
    	Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + usuarioId));
        usuarioRepository.delete(usuario);
        return ResponseEntity.ok().build();
    }

}
