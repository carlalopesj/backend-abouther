package com.abouther.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouther.DAO.IEsporte;
import com.abouther.model.Esporte;

@RestController
@CrossOrigin("*")
@RequestMapping("/esportes")
public class EsporteController {
	
	@Autowired
	private IEsporte dao;
	
	@GetMapping
	public List<Esporte> listaEsportes() {
	    return (List<Esporte>) dao.findAll();
	}

	
	/*
	@PostMapping 
	public Esporte criarEsporte (@RequestBody Esporte esporte) {
		Esporte esporteNovo = dao.save(esporte);
		return esporteNovo;
	}
	*/
}
