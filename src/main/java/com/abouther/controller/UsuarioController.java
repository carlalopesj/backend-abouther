package com.abouther.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abouther.DAO.IUsuario;
import com.abouther.model.Usuario;
import com.abouther.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuario dao;

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios() {
		return ResponseEntity.status(200).body(usuarioService.listarUsuario());
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> criarUsuario (@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}

	@PutMapping("/editar")
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
		usuarioService.deletarUsuario(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
		if (usuario == null || usuario.getEmail() == null || usuario.getSenha() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		// Busque o usuário pelo e-mail
		Usuario usuarioEncontrado = dao.findByEmail(usuario.getEmail());
		
		// Verifique se o usuário foi encontrado e valide a senha
		if (usuarioEncontrado != null && usuarioService.validarSenha(usuario)) {
			System.out.println("Login!");
			System.out.println("ID: " + usuarioEncontrado.getId());
			return ResponseEntity.ok(usuarioEncontrado);
		} else {
			System.out.println("Sem login!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
