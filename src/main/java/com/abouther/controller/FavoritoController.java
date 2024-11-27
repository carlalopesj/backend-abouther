package com.abouther.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouther.DAO.IFavorito;
import com.abouther.model.Favoritos;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/favoritos")

public class FavoritoController {

	@Autowired
	private IFavorito dao;
	
	// No seu método listaJogos, adicione um log para verificar os dados retornados
	@GetMapping("/{usuarioId}")
	public List<Favoritos> listaFavoritos(@PathVariable("usuarioId") Integer usuarioId) {
	    List<Favoritos> favoritos = dao.findByUsuarioId(usuarioId);
	    System.out.println(favoritos); // Adicione este log para verificar os dados
	    return favoritos;
	}

	
}
