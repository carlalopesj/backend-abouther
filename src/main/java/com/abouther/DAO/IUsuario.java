package com.abouther.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouther.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmailAndSenha(String email, String senha);

	Usuario findByEmail(String email);

}