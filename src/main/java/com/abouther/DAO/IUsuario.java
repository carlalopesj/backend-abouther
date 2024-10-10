package com.abouther.DAO;

import org.springframework.data.repository.CrudRepository;

import com.abouther.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
	Usuario findByEmailAndSenha(String email, String senha);

}