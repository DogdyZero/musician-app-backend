package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Troca;
import br.com.musicianapp.impl.ConsultasPadrao;

@RestController
@CrossOrigin
@RequestMapping("/troca")
public class TrocaController {
	@Autowired
	private Facade facade;
	
	@Autowired
	private Troca troca;
	
	@GetMapping("{id}")
	public Pessoa consultarUsuarioTroca(@PathVariable int id){
		this.troca.setId(id);
		this.facade.setParametro(ConsultasPadrao.TROCA_USUARIO);
		List<EntidadeDominio> entidades = facade.consultar(this.troca);
		return (Pessoa) entidades.get(0);
	}
}
