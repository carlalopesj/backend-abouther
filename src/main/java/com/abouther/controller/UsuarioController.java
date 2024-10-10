package com.abouther.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouther.DAO.IUsuario;
import com.abouther.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuario dao;
	
	@GetMapping
	public List<Usuario> listaUsuarios() {
		return (List<Usuario>) dao.findAll();
	}
	
	
	@PostMapping("/cadastrar")
	public Usuario criarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuarioNovo;
	}
	
	@PostMapping("/login")
	public Optional<Usuario> login(@RequestBody Usuario usuario) {
	    Optional<Usuario> usuarioEncontrado = Optional.of(dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha()));
	    
	    if (usuarioEncontrado.isPresent()) {
	        System.out.println("Login!");
	        return usuarioEncontrado;
	    } else {
	    	System.out.println("Sem login!");
	        return null;
	    }
	}

}
