package br.com.musicianapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Estoque;
@CrossOrigin
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private Facade facade;
	
	@PostMapping
	public Estoque salvar(@RequestBody Estoque estoque) {
		facade.salvar(estoque);
		return null;
	}
}
