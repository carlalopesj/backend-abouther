package com.abouther.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abouther.model.Jogo;

public interface IJogo extends CrudRepository<Jogo, Integer>{

	List<Jogo> findByEsporteId(Integer idEsporte);
	
}