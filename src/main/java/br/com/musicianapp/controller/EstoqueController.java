package br.com.musicianapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Estoque;
import br.com.musicianapp.impl.LoggerResourceImpl;
@CrossOrigin
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private Facade facade;
	
	@Autowired
	private LoggerResourceImpl logger;
	
	@PostMapping
	public Estoque salvar(@RequestBody Estoque estoque) {
		logger.salvarLoggerResource(EstoqueController.class, estoque, "salvarProduto");

		facade.salvar(estoque);
		return null;
	}
	@PutMapping("{id}")
	public Object alterarProduto(@RequestBody Estoque estoque, @PathVariable int id){
		logger.salvarLoggerResource(id,EstoqueController.class, estoque, "alterarProduto");

		estoque.setId(id);
		this.facade.alterar(estoque);
//		if(resultado!=null) {
//			return resultado;
//		}
		return null;
	}
}
