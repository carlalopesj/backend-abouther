package com.abouther.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abouther.model.Favoritos;

public interface IFavorito extends CrudRepository<Favoritos, Integer>{

	List<Favoritos> findByUsuarioId(Integer usuarioId);
	
}