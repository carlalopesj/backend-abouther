package com.abouther.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouther.DAO.IJogo;
import com.abouther.model.Jogo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jogos")

public class JogoController {

	@Autowired
	private IJogo dao;
	
	// No seu método listaJogos, adicione um log para verificar os dados retornados
	@GetMapping("/{idEsporte}")
	public List<Jogo> listaJogos(@PathVariable("idEsporte") Integer idEsporte) {
	    List<Jogo> jogos = dao.findByEsporteId(idEsporte);
	    System.out.println(jogos); // Adicione este log para verificar os dados
	    return jogos;
	}

	
}
